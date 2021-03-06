package datastructures;

import datastructures.linkedlist.SingleLL;

public class SLLUsage{

    public static void main(String[] args){
        
        SingleLL<Integer> sl = new SingleLL<Integer>();
        System.out.println(sl);

        // System.out.println(sl.isEmpty());
        sl.append(1);
        System.out.println(sl);

        sl.append(2);
        System.out.println(sl);

        sl.append(1);
        System.out.println(sl);

        // System.out.println(sl.get(4));
        // System.out.println(sl.get(2));
        
        // sl.append(3);
        // sl.append(4);
        // sl.insert(10,2);
        // System.out.println(sl);
        // System.out.println(sl.size());
        // System.out.println(sl.isEmpty());

        // sl.append(2);
        // System.out.println(sl);
        // sl.remove(2);
        // System.out.println(sl);
        // sl.removeFirst();
        // System.out.println(sl);

        // sl.insert(-4,3);
        // System.out.println(sl);

        sl.deleteMin();
        System.out.println(sl);

    }

}