package datastructures;
import datastructures.stack.*;

public class UsageArrayStack{

    public static void main(String[] args){
        ArrayStack<Integer> s = new ArrayStack<Integer>();
        

        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("three elements (1,2,3): " + s);
        System.out.println("popping last (3): " + s.pop());
        System.out.println("two elements (1,2): " + s);
        s.push(4);
        System.out.println("should be (1,2,4) and NOW IT IS!!!: " + s);
        
    }

}