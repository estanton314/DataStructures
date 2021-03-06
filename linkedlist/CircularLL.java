package datastructures.linkedlist;

public class CircularLL<T extends Comparable<T>> implements LinkedList<T>{

    private Node head;

    class Node{
        T data;
        Node next;

        Node(T d){
            data = d;
            next = null;
        }
    }

    public CircularLL(){
        head = null;
    }

    public void append(T item){
        
        Node newNode = new Node(item);
        Node temp = head;

        if(temp==null){
            //List is empty
            head = newNode;
            newNode.next=head; //added
            return;
        }

        //list isnt empty
        while(temp.next!=head){ //changed
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next=head; //added
    }
    
    //if pos exceeds length of list, item is appended to the list at the end
    public void insert(T item, int pos){
        Node newNode = new Node(item);
        
        //add to front of list
        if(pos==1){
            
            Node temp = head; //added
            while(temp.next!=head){
                temp=temp.next;
            }
            
            newNode.next=head;
            head=newNode;

            
            temp.next=head; //end of added

            return;
        }

        //add to end
        if(pos==this.size()+1){ //added
            Node temp = head; 
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.next=head; //end of added
            return;
        }

        //add to middle
        Node temp = head;
        Node prev = head; //so it works w only one element too

        for(int d=2;(d<=pos);d++){//we need to NOT stop at penultimate node ... &&(temp.next!=head);d++){ //changed
            prev = temp;
            temp = temp.next;
            if(temp==head){ //added. here is where we check that temp isnt head (like earlier when we had temp.next!=head, except this time we have processed last node)
                break;
            }
        }

        newNode.next=prev.next;
        prev.next = newNode;

    }

    public String toString(){
        String ret = "[";

        Node temp = head;

        if(head!=null){ //added. checking explicitly now bc dowhile doesnt check for the first iteration
            do{
                ret += (temp.data+",");
                temp = temp.next;
            }while(temp!=head);
        }

        ret+="]";
        return ret;
    }
    
    public T get(int index){
        Node temp = head;
        
        if(head==null){
            return(null);
        }

        if(index==1){
            return(head.data);
        }

        temp = temp.next;
        
        for(int i=2;(i<=index)&&(temp!=head);i++){ //temp!=head, NOT temp!=null
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
        Node temp = head; ///fix in progress
        
        while(temp.next != head) {
            temp = temp.next;
        }
        head = head.next;
        temp.next = head;
    }

    public void remove(T item){ //fix
        //empty list
        if(head==null){
            return;
        }
        //removing first item
        if(head.data==item){
           removeFirst();
        }
        //removing middle/end item
        Node temp = head;
        Node prev = head;
        for(;temp!=null;temp=temp.next){ //WRONGGG
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

        if(temp==null){
            return false;
        }

        do {
            if(temp.data == item) {
                return true;
            }
            temp = temp.next;
        } while(temp != head);

        return false;
    }

    public boolean isEmpty(){
        return(head==null);
    }

    public int size(){
        int d = 0;
        Node temp = head;

        if(temp==null){ //added; explicit check now
            return 0; //added
        }

        while(temp.next!=head){ //changed
            d += 1;
            temp = temp.next;
        }
        d+=1; //added to account for last element
        return d;
    }

    public void deleteMin() { /////fixed?
        if((head == null) || (head.next == head)){
            head = null;
            return;
        }
        Node currNode, prev, prevMin;
        
        currNode = head.next;
        prev = head;
        prevMin = null;

        T min_item = head.data;

        while(currNode != head) {
            if(min_item.compareTo(currNode.data) > 0) {
                min_item = currNode.data;
                prevMin = prev;
            }
            prev = currNode;
            currNode = currNode.next;
        }
        if(prevMin == null) {
            Node temp = head;
            head = head.next;
            temp = null;
        }
        else {
            Node temp = prevMin.next;
            prevMin.next = prevMin.next.next;
            temp = null;
        }
    }

}



//another way to the while loop in size:::::
// do{
//     d+=1;
//     temp = temp.next;
// }while(temp!=head);