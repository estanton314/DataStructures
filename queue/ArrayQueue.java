package datastructures.queue;

import java.util.ArrayList;

public class ArrayQueue<T> implements MyQueue<T>{

    private ArrayList<T> arr;
    private int head, tail;

    private static final int MAX = 512;

    public ArrayQueue(){
        head = tail = -1;
        arr = new ArrayList<T>();
    }

    public void enqueue(T item){
        tail+=1;
        arr.add(tail,item);
    }

    public T dequeue(){
        head+=1;
        return(arr.get(head));
    }

    public boolean isEmpty(){
        return(head==tail);
    }

    public boolean isFull(){
        return(tail==(MAX-1));
    }

    public String toString(){ 
        String ret = "[";

        for(int i=head+1; i<=tail;i++){ 
            ret += (arr.get(i) + ","); 
        }
        ret += "]";
        return(ret);
    }

}