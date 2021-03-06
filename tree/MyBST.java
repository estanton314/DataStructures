package datastructures.tree;

import java.util.Arrays;
import java.lang.Math;

import datastructures.tree.MyTree;
import datastructures.queue.ArrayQueue;
import datastructures.stack.ArrayStack;

public class MyBST implements MyTree{

    private Node root;
    private String printString;

    class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public MyBST(){
        root = null;
    }

    private MyBST(Node temp){
        root = temp;
    }

    private void recursiveInsert(Node curr, int item){ //FIX? or?
        if (curr==null){
            Node newNode = new Node(item);
            root = newNode;
            return;
        }
        if(curr.left==null&&curr.right==null){ //leaf node
            Node newNode = new Node(item);
            if(item<=curr.data){
                curr.left=newNode;
            }
            else{
                curr.right=newNode;
            }
            return;
        }

        //NOT a leaf
        if(item<=curr.data){
            recursiveInsert(curr.left,item);
        }
        else{
            recursiveInsert(curr.right,item);
        }
    }

    public void insert(int item){
        //recursiveInsert(root,item);
        Node newNode = new Node(item);

        if(root==null){
            root = newNode;
            return;
        }

        Node temp = root;
        Node parent = null;
        boolean isLeft = false;

        while(temp!=null){
            parent = temp;
            if(item<=temp.data){
                temp = temp.left;
                isLeft = true;
            }
            else{
                temp = temp.right;
                isLeft = false;
            }
        }
        if(isLeft){
            parent.left = newNode;
        }
        else{
            parent.right = newNode;
        }

        
    }

    private boolean recursiveSearch(Node curr, int item){ //FIXXX?
        
        if(curr==null){
            return false;
        }
        
        if(curr.data==item){
            return(true);
        }
        else if(item<curr.data){
            return(recursiveSearch(curr.left,item));
        }
        else{
            return(recursiveSearch(curr.right,item));
        }
    }

    public boolean search(int item){
    
        //return(recursiveSearch(root,item));
        Node temp = root;

        while(temp!=null){
            if(item==temp.data){
                return(true);
            }
            else if(item<temp.data){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        return(false);
    }

    public void remove(int item){
        if(root==null){
            return;
        }

        if(countChildren(root)==0){
            if(root.data==item){
                root = null;
            }
            return;
        }

        if(countChildren(root)==1 &&root.data==item){
            if(root.left==null){
                root = root.right;
            }
            else{
                root = root.left;
            }
            return;
        }

        //get to the right current and parent
        Node curr = root;
        Node parent = null;
        boolean isLeft = false;
        while(curr!=null && curr.data!=item){
            parent = curr;
            if(item<=curr.data){
                curr = curr.left;
                isLeft = true;
            }
            else{
                curr = curr.right;
                isLeft = false;
            }
        }

        if(curr==null){ //Node item does not exist
            return;
        }

        if(countChildren(curr)==0){ //Leaf node
            if(isLeft){
                parent.left=null;
            }
            else{
                parent.right=null;
            }
        }

        if(countChildren(curr)==1){ //Node w single child
            if(isLeft){
                if(curr.left==null){
                    parent.left=curr.right;
                }
                else{
                    parent.left=curr.left;
                }
            }
            else{
                if(curr.left==null){
                    parent.right=curr.right;
                }
                else{
                    parent.right=curr.left;
                }
            }
        }

        if(countChildren(curr)==2){ //Node w two children
            //find the smallest node on the right of the curr
            Node r = curr.right;
            while(r.left!=null){
                parent = r;
                r = r.left;
            }
            //swap in the new value to curr
            curr.data=r.data;
            //delete r
            if(r==curr.right){
                curr.right=r.right;
            }
            else{
                parent.left=r.right;
            }
        }

    }

    private int countChildren(Node curr){
        if(curr==null){
            return -1;
        }
        if(curr.left==null && curr.right==null){
            return(0);
        }
        else if(curr.left==null&&curr.right!=null){
            return(1);
        }
        else if(curr.left!=null&&curr.right==null){
            return(1);
        }
        return(2);
    }

    private void recursiveInOrder(Node  curr){
        if(curr==null){
            return;
        }
        recursiveInOrder(curr.left);
        printString+=(curr.data+",");
        recursiveInOrder(curr.right);
    }

    private void recursivePreOrder(Node  curr){
        if(curr==null){
            return;
        }
        printString+=(curr.data+",");
        recursivePreOrder(curr.left);
        recursivePreOrder(curr.right);
    }

    private void recursivePostOrder(Node  curr){
        if(curr==null){
            return;
        }
        recursivePostOrder(curr.left);
        recursivePostOrder(curr.right);
        printString+=(curr.data+",");
    }

    public String inOrder(){
        printString = "";
        recursiveInOrder(root);
        printString += "";
        return(printString);
    }

    public String preOrder(){
        printString = "";
        recursivePreOrder(root);
        printString += "";
        return(printString);
    }

    public String postOrder(){
        printString = "";
        recursivePostOrder(root);
        printString += "";
        return(printString);
    }

    public int size(){
        return(recursiveSize(root));
    }

    private int recursiveSize(Node curr){
        if(curr==null){
            return 0;
        }
        else{
            return (1+recursiveSize(curr.left)+recursiveSize(curr.right));
        }
    }

    public int depth(){
        return recursiveDepth(root);
    }

    private int recursiveDepth(Node curr){
        if(curr==null){
            return 0;
        }
        else{
            return (1+Math.max(recursiveDepth(curr.left),recursiveDepth(curr.right)));
        }
    }

    private Node recursiveBalanceTree(int[] arr){
        int n = arr.length;
        if(n==0){
            return null;
        }
        else{
            int mid = n/2;
            Node newNode = new Node(arr[mid]);
            newNode.left = recursiveBalanceTree(Arrays.copyOfRange(arr, 0, mid));
            newNode.right = recursiveBalanceTree(Arrays.copyOfRange(arr, mid+1, n));
            return(newNode);
        }
    }

    public MyBST balanceTree(){
        int[] arr = new int[size()];
        int i=0;
        
        for(String s: inOrder().split(",")){
            arr[i++] = Integer.parseInt(s);
        }
        
        return(new MyBST(recursiveBalanceTree(arr)));

    }

    public boolean isBalanced(){

        if(root==null){
            return true;}//added

        if(Math.abs(recursiveDepth(root.left)-recursiveDepth(root.right))>1){
            return(false);
        }
        else{
            return true;
        }
    }

    public String breadthFirst(){
        printString = "";

        ArrayQueue<Node> q = new ArrayQueue<Node>();

        q.enqueue(root);
        while(!q.isEmpty()){
            Node temp = q.dequeue();
            if(temp!=null){
                printString += (temp.data + ", ");
                q.enqueue(temp.left);
                q.enqueue(temp.right);
            }
        }
        return(printString);
    }

    public String depthFirst(){
        printString = "";

        ArrayStack<Node> s = new ArrayStack<Node>();

        s.push(root);
        while(!s.isEmpty()){
            Node temp = s.pop();
            if(temp!=null){
                printString+=(temp.data+",");
                s.push(temp.left);
                s.push(temp.right);
            }
        }
        return(printString);
    }


}