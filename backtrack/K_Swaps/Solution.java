public class Solution {
    //greedy will not work as there is duplicasy in the number
    //we need to find all the permuations and find the maximum number
    //time ->
    /*
    our tree has limited heght of k 
    each node -> finds max and recur for next pointer
    for lth level (k) -> nu,ber of nuodes = n. n-1. n-1. ... n-l+1
    simialary find number of nodes for all levels

    for done by each node -> n^2

    time - > number of nodes * work done by each node -> n^2 (n!/(n-k)!)
    */
    private String best;

    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        best = s;
        StringBuilder sb = new StringBuilder(s);

        back(0, k, sb);

        return best;
    }

    private void back(int index, int k, StringBuilder sb) {
        String current = sb.toString();

        if (current.compareTo(best) > 0) {
            best = current;
        }

        if (index == sb.length() - 1 || k == 0) {
            return;
        }

        int maxDigit = '0';

        // Find the maximum digit in the remaining suffix.
        for (int j = index + 1; j < sb.length(); j++) {
            maxDigit = Math.max(maxDigit, sb.charAt(j));
        }

        // If no larger digit exists, move to the next position.
        if (maxDigit <= sb.charAt(index)) {
            back(index + 1, k, sb);
            return;
        }

        for (int j = index + 1; j < sb.length(); j++) {
            if (sb.charAt(j) == maxDigit) {
                swap(sb, index, j);

                back(index + 1, k - 1, sb);

                // Backtrack: restore the original string.
                swap(sb, index, j);
            }
        }
    }

    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}