//tc = 2^n
//sc = n
public class Recursion {
    public static int perfectSum(int[] arr, int k) {

        int n = arr.length;

        return recur(arr, k, n);
    }

    static int recur(int[] arr, int k, int n) {

        // sum formed
        if (k == 0) {
            return 1;
        }

        // no elements left
        if (n == 0) {
            return 0;
        }

        // include + exclude
        if (arr[n - 1] <= k) {

            return recur(arr, k - arr[n - 1], n-1)+recur(arr, k, n - 1);

        } else {
        //cant include
            return recur(arr, k, n - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 16, 8, 10};
        int k = 99;

        int ans = perfectSum(arr, k);

        System.out.println("Count of subsets = " + ans);
    }
}
