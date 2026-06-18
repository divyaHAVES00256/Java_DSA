public class Recursive{
    //tc = O(2^n)
    //sc = O(n)
    public static int knapsack(int[] wt, int[] prof, int cap, int n){
        //base case
        //if no weights, or no capacity -> 0 profit gained
        if(n == 0 || cap == 0) return 0;

        if(wt[n-1] <= cap){
            //wt <= cap
            //take, dont take
            return Math.max(prof[n-1] + knapsack(wt, prof, cap-wt[n-1], n-1), knapsack(wt, prof, cap, n-1));
        } else {
            // wt>cap
            //cant take
            return  knapsack(wt, prof, cap, n-1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] wt = {1, 3, 4, 5};
        int[] prof = {1, 4, 5, 7};
        int cap = 7;

        int maxProf = knapsack(wt, prof, cap, n);

        System.out.println(maxProf);
    }
}