import java.util.*;

public class Heap_Sort {
    static void heapify(int[] arr, int i, int n){
        System.out.println(" heapify " + Arrays.toString(arr));

        int l = 2*i + 1;
        int r = 2*i + 2;

        int max = i;

        //left is larger
        if(l<n && arr[l]>arr[max]){
            max = l;
        }

        //right is larger
        if(r<n && arr[r]>arr[max]){
            max = r;
        }

        if(max!=i){
            int temp = arr[max];
            arr[max]= arr[i]; 
            arr[i] = temp;

            heapify(arr, max, n);
        }

    }

    static void heapSort(int[] arr){
    //find all the non leaf nodes
    //ascending - max heap formation
    //insrt root to last of array -> swap(root to last ele) -> delete last -> heapify
     System.out.println("heap sort called ");

    //build max
        int n = arr.length;
        for(int i = n/2; i>=0; i--) {
     System.out.println("heapify for building ");

            heapify(arr, i, n);
        }
    //largest to last
        for(int i = n-1; i>=0; i--){
            
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //delete last
            //heapify on n-1 to 1 elements(size of arrya keep on decreasing)
     System.out.println(" heapify for sorting ");

            heapify(arr, 0, i);;
        }

    }
    public static void main(String[] args){
        int[] arr = {5, 1, 5, 0, -2, 9, 9, 3, 3, 10, -10, 0};
        // int[] arr = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
