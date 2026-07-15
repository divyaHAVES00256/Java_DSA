package egg_dropping_problem;

public class Recursion {
    //solving using mcm intution -> chck every floor 
    // time : e*2^f
    // space : 2^f
    public int superEggDrop(int e, int f) {
        return recur(e, f);
    }

    int recur(int e, int f){
        if(f == 0) return 0;
        if(f == 1) return 1;
        if(e == 1) return f;

        //what does this min specify?
        //it gives min number of operation requires
        int min = Integer.MAX_VALUE;
        for(int k = 1; k<=f; k++){
            // Testing dropping from floor k
            int temp = 1; // 1 attempt for the current drop

            // Math.max: We assume the worst-case outcome between breaking and surviving
            // If broken: we lost an egg, and we only need to check the (k-1) floors BELOW k.
            // If survived: we kept the egg, and we only need to check the (f-k) floors ABOVE k.
            temp += Math.max(recur(e-1, k-1), recur(e, f-k));

            // Math.min: Out of all the floors 'k' we could have started from, which one gave us the smallest worst-case?
            min = Math.min(temp, min);
        }

        return min;
    }
}
