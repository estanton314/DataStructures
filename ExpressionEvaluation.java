//current issue: doesnt take into account that operations of equal precedence cant push on top either
//look at InToPost.java

package datastructures;

import datastructures.stack.ArrayStack;

public class ExpressionEvaluation{

    public static void main(String args[]){
        
        String expression = "3-4/2+1-8*3";
        double val = 0;

        ArrayStack<String> nums = new ArrayStack<String>();
        ArrayStack<String> ops = new ArrayStack<String>();

        for(int i=0;i<expression.length();i++){

            String c = Character.toString(expression.charAt(i));

            if(isNumeric(c)){
                nums.push(c);
            }

            else{
                if(c.equals("*")||c.equals("/")){
                    ops.push(c);
                }
                if(c.equals("+")||c.equals("-")){
                    if(ops.size()>0&&(ops.peek().equals("*")||ops.peek().equals("/"))){
                        Double second = Double.parseDouble(nums.pop());
                        System.out.println(nums);
                        Double first = Double.parseDouble(nums.pop());
                        System.out.println(nums);
                        String o = ops.pop();
                        System.out.println(first + ", " + second + ", " + o);
                        val = operate(first,second,o);
                        nums.push(Double.toString(val));
                        ops.push(c);
                        
                    }
                    else{
                        ops.push(c);
                    }
                }
            }

        }


        for(int i=0;i<(nums.size());i++){
            while(ops.size()>0){
            Double second = Double.parseDouble(nums.pop());
            Double first = Double.parseDouble(nums.pop());
            String o = ops.pop();
            val = operate(first,second,o);
            nums.push(Double.toString(val));
        
        }
        }


        System.out.println("expression have the value: " + nums.peek());

    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d");  //match a number with optional '-' and decimal.
      }

    public static double operate(double one, double two, String o){
        if(o.equals("*")){
            double value = one*two;
            System.out.println("val: " + value);
            return(value);
        }
        if(o.equals("/")){
            double value = one/two;
            System.out.println("val: " + value);
            return(value);
        }
        if(o.equals("+")){
            double value = one+two;
            System.out.println("val: " + value);
            return(value);
        }
        if(o.equals("-")){
            double value = one-two;
            System.out.println("val: " + value);
            return(value);
        }
        return(0);
    }



}