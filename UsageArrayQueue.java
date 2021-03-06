package datastructures;

import datastructures.queue.ArrayQueue;

public class UsageArrayQueue{

    public static void main(String[] args){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>();

        q.enqueue(1);
        System.out.println(q);
        q.enqueue(2);
        System.out.println(q);
        q.enqueue(3);
        System.out.println(q);

        System.out.println("Removed: " + q.dequeue());
        System.out.println(q);
        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
    }

}