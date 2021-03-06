package datastructures.linkedlist;

public class SingleLL<T extends Comparable<T>> implements LinkedList<T>{

    private Node head;

    class Node{
        T data;
        Node next;

        Node(T d){
            data = d;
            next = null;
        }
    }

    public SingleLL(){
        head = null;
    }

    public void append(T item){
        
        Node newNode = new Node(item);
        Node temp = head;

        if(temp==null){
            //List is empty
            head = newNode;
            return;
        }

        //list isnt empty
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    //if pos exceeds length of list, item is appended to the list at the end
    public void insert(T item, int pos){
        Node newNode = new Node(item);
        
        //add to front of list
        if(pos==1){
            newNode.next=head;
            head=newNode;
            return;
        }

        //add to middle/end of list
        Node temp = head;
        Node prev = head; //so it works w only one element too

        for(int d=2;(d<=pos)&&(temp!=null);d++){
            prev = temp;
            temp = temp.next;
        }

        newNode.next=prev.next;
        prev.next = newNode;

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
    
    public T get(int index){
        Node temp = head;
        
        if(head==null){
            return(null);
        }
        
        for(int i=1;(i<=index)&&(temp!=null);i++){
            if(i==index){
                return temp.data;
            }
            temp = temp.next;
        }
        return(null);
    }

    public void removeFirst(){
        if(head==null){
            return;
        }
        Node temp = head;
        head = head.next;
        temp = null;
    }

    public void remove(T item){
        //empty list
        if(head==null){
            return;
        }
        //removing first item
        if(head.data==item){
            Node temp = head;
            head = head.next;
            temp = null; //frees block of memory
            return;
        }
        //removing middle/end item
        Node temp = head;
        Node prev = head;
        for(;temp!=null;temp=temp.next){
            if(temp.data==item){
                prev.next=temp.next;
                temp=null;
                return;
            }
            prev = temp;
        }
    }

    public boolean isPresent(T item){
        Node temp = head;

        while(temp!=null){
            if (temp.data==item){
                return true;
            }
            temp = temp.next;
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

    public void deleteMin(){
        if(head==null||head.next==null){
            head=null;
            return;
        }
        T min = head.data;
        int minPos = 1;
        int pos = 1;
        Node temp = head.next;
        while(temp!=null){
            pos+=1;
            if(temp.data.compareTo(min)<0){
                min = temp.data;
                minPos = pos;
            }
            temp = temp.next;
        }

        Node t = head;
        Node p = head;
        if(minPos ==1){
            head = head.next;
            t = null;
            return;
        }
        pos = 1;
        while(pos<minPos){
            pos+=1;
            p = t;
            t = t.next;
        }
        p.next = t.next;
        t = null;

    }

}