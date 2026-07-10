package palindrom_partitioning;
/*
In this approach, we recursively evaluate the following conditions:

Base Case: If the current string is a palindrome, then we simply return 0, no Partitioning is required.
Else, like the Matrix Chain Multiplication problem,
we try making cuts at all possible places,
recursively calculate the cost for each cut
return the minimum value.
*/

//tc:
//total length -> n
//for every substring we either partition it or not at all -> 2^n-1 choies of partition
//total -> n * 2^n

//but at worst case it goes to 3^n as there are left and right branch mkaing it grow even higher

//sc: n(max depth of the tree)

public class Recursion {
     static int palPartition(String s) {
        // code here
        return recur(s, 0, s.length()-1);
    }
    //mcm
    //0, n-1 (min 0 partition, max n-1 partitions)
    //k -> 0, n-2
    //if already palindrom -> why make partition? -> simply return 0 for that substring
    //else -> mcm
    static int recur(String s, int i, int j){
        if(i>=j) return 0;
        
        if(ispalin(s, i, j)) return 0; //is already palindrom -> no need to go further
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++){
            //left/reight
            int left = recur(s, i, k);
            int right = recur(s, k+1, j);
            //cost
            int cost = left+right+1;
            min = Math.min(min, cost);
        }
        // System.out.println(min);
        return min;
    }

    static boolean ispalin(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}
