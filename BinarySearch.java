package datastructures;

import java.util.Arrays;

public class BinarySearch{

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        //System.out.println(binser(arr,7, arr.length));
        System.out.println(wrapperBinary(arr,9,10));
    }

    public static boolean binser(int[] arr, int item){
        System.out.println(Arrays.toString(arr));
        int mid = arr.length/2;
        System.out.println(mid);
        if(arr[mid]==item){
            return true;
        }
        else if(arr[mid]<item){
            binser(Arrays.copyOfRange(arr,0,(arr.length/2)-1),item);
        }
        else{
            binser(Arrays.copyOfRange(arr,(arr.length/2)+1,arr.length-1),item);
        }
        return false;
    }

    private static boolean recursiveBinary(int[] arr, int beg, int end, int item){
        if(beg>end){
            return false;
        }
        int mid = (beg+end)/2;

        if(arr[mid]==item){
            return true;
        }
        else if (arr[mid]<item){
            return(recursiveBinary(arr,mid+1,end,item));
        }
        else{
            return(recursiveBinary(arr,beg,mid-1,item));
        }
    }

    public static boolean wrapperBinary(int[] arr, int size, int item){
    //     int low,high, mid;
    //     low = 0;
    //     high = size-1;

    //     while(low<high){
    //         mid = (low+high)/2;
    //         if(arr[mid]==item){
    //             return true;
    //         }
    //         else if(arr[mid]<item){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     if(arr[mid]==item){
    //         return true;
    //     }
    //     return false;
        return(recursiveBinary(arr,0,size-1,item));
    }

}