package datastructures.stack;

public interface MyStack<T> {
    public void push(T item);
    public T pop();
    public T peek();
    public int size();
    public boolean isEmpty();
    public String toString();

}