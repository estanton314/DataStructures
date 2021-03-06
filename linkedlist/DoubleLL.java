package datastructures.linkedlist;

public class DoubleLL<T> implements LinkedList<T>{

    private Node head;
    private Node tail;

    class Node{
        T data;
        Node next;
        Node prev;

        Node(T d){
            data = d;
            next = null;
            prev = null;
        }
    }

    public DoubleLL(){

        head = null;
        tail = null;
        //head.next = tail;
        //tail.prev=head;
    }

    public void append(T item){
        
        Node newNode = new Node(item);
        Node temp = tail;

        if(temp==null){
            //List is empty
            head = newNode;
            tail = head;
            return;
        }

        
        temp.next = newNode;
        newNode.prev = temp;
        tail = newNode;
    }
    
    //if pos exceeds length of list, item is appended to the list at the end //FIX
    public void insert(T item, int pos){
        Node newNode = new Node(item);
        
        if(pos==1){
            newNode.next=head;
            head.prev = newNode;
            head=newNode;
            return;
        }

        Node temp = head;
        Node b4 = head; //so it works w only one element too

        for(int d=2;(d<=pos)&&(temp!=null);d++){
            b4 = temp;
            temp = temp.next;
        }

        newNode.next=temp;
        newNode.prev=b4;
        b4.next = newNode;
        temp.prev=newNode;

    }

    public String toString(){
        String ret = "[";

        Node temp = head;
        while(temp!=null){
            ret += (temp.data+",");
            temp = temp.next;
        }
        ret+="]";
        return ret;
    }
    
    public void remove(T item){
        if(head==null&&tail==null){
            return;
        }
        if(head.data==item){
            Node temp = head;
            head = head.next;
            head.prev=null;
            temp = null; //frees block of memory
            return;
        }
//FIX
        Node temp = head;
        Node b4 = head;
        for(;temp!=null;temp=temp.next){
            if(temp.data==item){
                Node following = temp.next;
                b4.next=following;
                following.prev=b4;
                temp=null;
                return;
            }
            b4 = temp;
        }
    }

    public boolean isPresent(T item){
        Node temp = head;

        while(temp!=null){
            if (temp.data==item){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return(head==null);
    }

    public int size(){
        int d = 0;
        Node temp = head;
        while(temp!=null){
            d += 1;
            temp = temp.next;
        }
        return d;
    }


}