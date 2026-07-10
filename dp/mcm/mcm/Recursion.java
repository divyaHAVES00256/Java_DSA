package mcm.mcm;

public class Recursion{
    //tc : n 2^n (we try every possible parenthesization, which leads to exponential recursion)
    //sc : n (comes from the recursion call stack depth in the worst case)
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int i = 1;
        int j = n-1;
       return recur(arr, i, j);
        
    }
    
    static int recur(int[] arr, int i, int j){
        //base
        //no elemnt or out of bound 
        if(i>=j) return 0;
        
        //split choices
        int min = Integer.MAX_VALUE; //calculates local and gloab cost with min value
        for(int k = i; k<=j-1; k++){
            int temp = recur(arr, i, k)+recur(arr, k+1, j); //left and right cost
            int c = arr[i-1]*arr[k]*arr[j]; //merge cost of left and right
            min = Math.min(min, temp+c); //min out of all split possible
        }
        
        //final answer
        return min;
    }
}