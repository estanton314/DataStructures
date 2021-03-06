package datastructures.queue;

import java.util.Arrays;
import java.util.ArrayList;

public class CircularQueue<T> implements MyQueue<T>{

    private ArrayList<T> arr;
    private int head, tail;
    private static final int MAX = 4;

    public CircularQueue(){
        head = tail = -1;
        arr = new ArrayList<T>(null); //added the null
    }

    public boolean isEmpty(){
        return(head==-1); //could also say tail==-1
    }

    public boolean isFull(){
        if((head==(tail+1)%MAX)){//||(head==0&&tail==MAX-1)){
            return(true);
        }
        else{
            return(false);
        }
    }

    public void enqueue(T item){
        if(head==-1){
            //now there is something in the queue
            head = 0;
        }
        tail=(tail+1)%MAX;
        arr.add(tail,item);

    }

    public T dequeue(){
        if(head==-1){
            return null; //have to return null
        }
        
        T ret = arr.get(head);

        if(head==tail){
            //queue is empty, so reset
            head=tail=-1;
        }
        else{
            head=(head+1)%MAX;
        }
        return(ret);
    }


    public String toString() {
        String ret = "[";

        if(head != -1) {
            int i = head;
            do {
                ret += ((arr.get(i) != null ? arr.get(i) + "," : "" ));
                i = (i + 1) % MAX;
            } while(i != head);
        }
        ret += "]";

        return ret;
    }

//public String toString(){ //currently doesnt print anything after head=tail even if you've looped around
        
  //      return(Arrays.toString(arr) + " head- " + head + ", tail- " + tail);
        // String ret = "[";
        // if(head!=-1){
        //     System.out.println("Head: " + head + ", tail: " + tail);
        //     for(int i=head;i<tail;i=(i+1)%MAX){
        //         ret +=(arr[i] + ",");
        //     }
        //     ret += (arr[tail]);
        // }
        // ret = ret + "]" + ", head = " + head + ", tail = " + tail;
        // return(ret);
    //}
}