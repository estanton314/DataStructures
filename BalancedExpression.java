package datastructures;

import java.util.Scanner;
import datastructures.stack.SLLStack;

public class BalancedExpression{

    public static void main(String[] args){

        boolean balanced = false;
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("give expression");

        input = sc.nextLine();

        balanced = balanced(input);

        System.out.println("balanced");


    }

    public static boolean isOpenBracket(char c){
        if(c=='('||c==('{')||c==('[')){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isClosedBracket(char c){
        if(c==')'||c==']'||c=='}'){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isBracket(char c){
        return (isOpenBracket(c)||isClosedBracket(c));
    }

    public static boolean balanced(String input){
        SLLStack<Character> st = new SLLStack<Character>();

        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(!isBracket(ch)){
                continue;
            }
            if(isOpenBracket(ch))
                st.push(ch);
            else{
                char d = st.pop();
                if (!isBalanced(d,ch)){
                    System.out.println("The expression is not balanced!");
                    return(false);
                }
            }
        }
        return(st.isEmpty());
    }

    public static boolean isBalanced(char ch1, char ch2){
        if(ch1=='('&&ch2==')'){
            return(true);
        }
        if(ch1=='['&&ch2==']'){
            return(true);
        }
        if(ch1=='{'&&ch2=='}'){
            return(true);
        }
        return(false);
    }

}