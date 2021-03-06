package datastructures;

import datastructures.linkedlist.DoubleLL;

public class DLLUsage{

    public static void main(String args[]){

        DoubleLL<String> d = new DoubleLL<String>();

        d.append("3");
        d.append("2");
        System.out.println(d);
        d.append("4");
        System.out.println(d);
        d.insert("8",3);
        System.out.println(d);
        d.remove("1");
        System.out.println(d);

        // int[] arr = new int[4];
        // System.out.println(arr.length);
        // arr[0] = 3;
        // System.out.println(arr.length);

    }

}