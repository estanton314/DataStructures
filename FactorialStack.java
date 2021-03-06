package datastructures;

//import datastructures.stack.ArrayStack;
import datastructures.stack.SLLStack;

public class FactorialStack {

    public static void main(String[] args){
        int n = 4;

        SLLStack<Integer> s = new SLLStack<Integer>();

        for(int i=n;i>0;i--){
            s.push(i);
        }

        System.out.println(s.toString());

        int fact = 1;
       
        //VERSION ONE
        /*while(!s.isEmpty()){
            fact = fact*s.pop();
        }*/

        //VERSION TWO
        for(int i=s.size();i>0;i--){
            fact=fact*s.pop();
        }
        System.out.println(fact);

    }

}