package problems.SubsetSum;

public class Recursion {
    static Boolean isSubsetSum(int arr[], int sum) {
        return recursion(arr, sum, arr.length);
    }
    
    // tc:2^n sc:1
    static boolean recursion(int arr[], int sum, int n){
        if(n == 0 && sum == 0) return  true;
        if(sum == 0) return true;
        if(n == 0) return false;
        
        //choices
        if(arr[n-1] <= sum){
            return recursion(arr, sum-arr[n-1], n-1) || recursion(arr, sum, n-1);
        } else {
            return recursion(arr, sum, n-1);
        }
    }
}
