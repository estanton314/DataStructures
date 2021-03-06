package datastructures.stack;
import java.util.*;

public class ArrayStack<T extends Comparable<T>> implements MyStack<T>{

    private ArrayList<T> arr;
    private int top;
    private static final int MAX = 512; //do i need this now?

    public ArrayStack(){
        arr = new ArrayList<T>();
        for(int i = 0; i < MAX; i++)
            arr.add(null);
        top = -1;
    }

    public void push(T item){
        arr.add(++top,item);
    }

    public T pop(){
        return(arr.get(top--));
    }

    public T peek(){
        return(arr.get(top));
    }

    public int size(){
        return(top+1);
    }

    public boolean isEmpty(){
        return(top==-1);
    }

    public String toString(){
        String ret = "[";
        for(int i=top;i>=0;i--){
            ret+=(arr.get(i) + ",");
        }
        ret+="]";
        return(ret);
    }

    public boolean isFull(){
        return (top==(MAX-1));
    }

    public void insertAtTheBottom(T item){
        if(isEmpty()){
            push(item);
        }
        else{
            T temp = pop();
            insertAtTheBottom(item);
            push(temp);
        }
    }

}