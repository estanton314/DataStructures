package datastructures;

import datastructures.tree.MyBST;

public class UsageBST{

    public static void main(String[] args){
        MyBST t = new MyBST();

        t.insert(28);
        t.insert(12);
        t.insert(10);
        t.insert(15);
        t.insert(49);
        t.insert(40);
        t.insert(38);
        t.insert(60);
        t.insert(52);
        t.insert(55);
        t.insert(50);
        t.insert(54);

        System.out.println(t.inOrder());
        System.out.println(t.preOrder());
        System.out.println(t.postOrder());
        System.out.println(t.depthFirst());

        System.out.println(t.depth());

        MyBST newTree = t.balanceTree();
        System.out.println(newTree.depth());
        System.out.println(newTree.inOrder());

        System.out.println(t.isBalanced());
        System.out.println(newTree.isBalanced());
    
        System.out.println(t.breadthFirst());
        System.out.println(newTree.breadthFirst());
    
    }
}