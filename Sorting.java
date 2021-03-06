package datastructures;

import java.util.Arrays;

public class Sorting{

    public static void insertionSort(int[] arr, int beg, int end){
        // int n = end-beg+1; //how many numbers you have
        // for(int i=1;i<n;i++){
        //     for(int j = beg+i;j<end;j++){

        //     }
        // }

        int n = end-beg+1;
        for(int i=1;i<n;i++){ //insert ith element
            for(int j=i;j>0;j--){ //check against array from 0 to i, going from end to beginning (i to 0)
                if(arr[j]< arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
    }

    //this is min selection sort
    //max selection sort- change arr[i]<min to arr[i]>min (call min max for sanity)
    public static void selectionSort(int[] arr, int beg, int end){
        
        if(beg>=end){ //added
            return;
        }

        int min, minPos;
        min = arr[beg];
        minPos = beg;

        for(int i=beg + 1; i<=end; i++){ //i<=end, i<end+1
            if(arr[i]<min){
                min = arr[i];
                minPos = i;
            }
        }

        int temp = arr[beg];
        arr[beg] = arr[minPos];
        arr[minPos] = temp;

        if(beg<end){
        selectionSort(arr,beg+1,end);
        }   //OR for loop outside everything, for(int j=beg,j<end-1,j++), turn inner loop into i=j+1, mentions of beg are of j

    }

    public static void selectionIterative(int[] arr, int beg, int end){
        int min, minPos;
        min = arr[beg];
        minPos = beg;

        for(int j= beg;j<end-1;j++){
            for(int i=j + 1; i< end-1; i++){
                if(arr[i]<min){
                    min = arr[i];
                    minPos = i;
                }
            }

            int temp = arr[j];
            arr[j] = arr[minPos];
            arr[minPos] = temp;

        }

    }

    public static void bubbleSort(int[] arr, int beg, int end){

        //WRONG
        // for(int j = end;j>beg;j--){
        //     for(int i=beg+1;i<=j;i++){
        //         if(arr[i]<arr[i-1]){
        //             int temp = arr[i];
        //             arr[i-1] = arr[i];
        //             arr[i] = temp;
        //         }
        //     }

        // }

        //bubbleSort(arr,0,n-1);

        if(beg>end){return;}

        for(int i=beg;i<end;i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1]=temp;
                }
            }
        bubbleSort(arr,beg,end-1);

    }

    public static void mergeSort(int[] arr, int beg, int end){
        if(beg>=end){
            return;
        }
        int mid = (beg+end)/2;
        
        mergeSort(arr,beg,mid);
        mergeSort(arr,mid+1,end);
        merge(arr, beg, mid, end);
    }

    private static void merge(int[] arr, int beg, int mid, int end){
        int[] temp = new int[end-beg+1];
        int i, j, k;
        i = beg;
        j = mid+1;
        k = 0;
        while((i<=mid)&&(j<=end)){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        if(i==mid+1){
            while(j<=end){
                temp[k++]=arr[j++];
            }
        }
        else{
            while(i<=mid){
                temp[k++]=arr[i++];
            }
        }

        for(int id=0;id<temp.length;id++){
            arr[beg+id]=temp[id];
        }

    }

    public static String printArray(int[] arr, int beg, int end){
        String st = "";
        for(int i = beg; i<= end; i++){
            st+=arr[i] + ",";
        }
        return(st);
    }

    private static int partition(int[] arr, int beg, int end){
        int i,j;
        i=beg;j=end+1;
        do{
            do i++; while((i<=end)&&arr[beg]>arr[i]); //stops when i finds larger
            do j--; while(arr[beg] < arr[j]); //stops when j finds smaller
            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }while(i<=j);
        int  temp = arr[beg];
        arr[beg] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void quickSort(int[] arr, int beg, int end){
        if(beg>=end){
            return;
        }
        int pivot = partition(arr,beg,end);
        quickSort(arr,beg,pivot-1);
        quickSort(arr,pivot+1,end);
    }

    public static void main(String[] args){
        int[] arr = {9,2,4,6,5,4,3};
        int n = arr.length;

        System.out.println(printArray(arr,0,n-1));
        quickSort(arr,0,n-1);
        System.out.println(printArray(arr,0,n-1));
    }

}