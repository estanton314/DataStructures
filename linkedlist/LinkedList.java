package datastructures.linkedlist;

interface LinkedList <T>{

    public void insert(T item, int pos);
    public String toString();
    public void remove(T item);
    public boolean isPresent(T item);
    public boolean isEmpty();
    public int size();
}