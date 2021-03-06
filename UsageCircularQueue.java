package datastructures;

import datastructures.queue.CircularQueue; //who knows why im getting a fucking error

public class UsageCircularQueue{

    public static void main(String[] args){
        CircularQueue q = new CircularQueue();

        System.out.println(q);
        System.out.println(q.isFull());

        q.enqueue(1);
        System.out.println(q);
        System.out.println(q.isFull());
        q.enqueue(2);
        System.out.println(q);
        System.out.println(q.isFull());
        q.enqueue(3);
        System.out.println(q);
        System.out.println(q.isFull());
        q.enqueue(5);
        System.out.println(q);
        System.out.println(q.isFull());
        
        q.dequeue();
        System.out.println(q);
        System.out.println(q.isFull());
        q.dequeue();
        System.out.println(q);
        System.out.println(q.isFull());
        
        q.enqueue(6);
        System.out.println(q);
        System.out.println(q.isFull());

        q.enqueue(7);
        System.out.println(q);
        System.out.println(q.isFull());


        //  System.out.println("Removed: " + q.dequeue());
        //  System.out.println(q);
        //  System.out.println("Removed: " + q.dequeue());
        //  System.out.println("Removed: " + q.dequeue());
        //  System.out.println(q);
    }

}