package datastructures.queue;

public interface MyQueue<T> {
    public void enqueue(T item);
    public T dequeue();
    public boolean isEmpty();
    public boolean isFull();
}