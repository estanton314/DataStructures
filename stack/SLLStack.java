package datastructures.stack;

import datastructures.linkedlist.SingleLL;

public class SLLStack<T extends Comparable<T>> implements MyStack<T>{

    private SingleLL<T> top;

    public SLLStack(){
        top = new SingleLL<T>();
    }

    public void push(T item) {
        top.insert(item,1);
    }

    public T pop() {
        T i = top.get(1);
        top.removeFirst();
        return(i);
    }

    public T peek() {
        return top.get(1);
    }

    public int size() {
        return top.size();
    }

    public boolean isEmpty() {
        return top.isEmpty();
    }

    public String toString(){
        return top.toString();
    }



}