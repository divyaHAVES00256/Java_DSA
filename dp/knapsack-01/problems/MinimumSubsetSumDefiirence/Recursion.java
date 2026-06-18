//tc = 2^n * sum
//sc = n
public class Recursion {
    public int minDifference(int arr[]) {
        // code here 
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        int ans = Integer.MAX_VALUE;
        
        //recursion on the range (s1 = no elemnts to s1 = all the elemnets)
        //now this end range can be reduced to (all the lements)/2
        for(int i = 0; i<=sum/2; i++){ //n/2
            //subset1 = i
            //subset2 = sum-1;
           
            if(recur(arr, i, arr.length)) ans = Math.min(ans, Math.abs(i - (sum-i))); //2^n
        }
        
        return ans;
    }
    
    boolean recur(int[] arr, int i, int n){
        if(i == 0) return true;
        if(n == 0) return false;
        
        if(arr[n-1]<=i){
            return recur(arr, i-arr[n-1], n-1) || recur(arr, i, n-1);
        } else{
            return recur(arr, i, n-1);
        }
    }
}
