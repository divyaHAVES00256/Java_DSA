import java.lang.reflect.Array;
import java.util.Arrays;

public class N_Slots {
    static int min(boolean[] slots, int time) {

        System.out.println(Arrays.toString(slots));

        boolean changed = false;
        boolean[] copy = Arrays.copyOf(slots, slots.length);
        System.out.println(Arrays.toString(copy));

        for (int i = 0; i < slots.length; i++) {
            if (copy[i] == true) {
                if (i - 1 >= 0 && copy[i - 1] == false) {
                    slots[i - 1] = true;
                    changed = true;
                }

                if (i + 1 < slots.length && copy[i + 1] == false) {
                    slots[i + 1] = true;
                    changed = true;
                }
            }
            System.out.println(Arrays.toString(slots) + " time" + time);
            System.out.println(Arrays.toString(copy));
        }

        System.out.println();
        if (changed){
            time++;

            boolean left = false;
            for (int i = 0; i < slots.length; i++) {
                System.out.println(slots[i] + " aaa " + left);
                if (slots[i] == false) {
                    left = true;
                    break;
                }
            }
            System.out.println(" yyyy " + left);

            if (left) {
                System.out.println(Arrays.toString(slots) + " time uuuuuu " + time);
                return min(slots, time);
            }

        }
        System.out.println();
        System.out.println(Arrays.toString(slots) + " time zzzz " + time);
        return time;
    }

    public static void main(String[] args) {
        int N = 5, arr[] = { 1, 2, 3, 4, 5 };

        boolean[] slots = new boolean[N];
        // System.out.println(Arrays.toString(slots));

        for (int i = 0; i < arr.length; i++) {
            slots[arr[i] - 1] = true;
        }
        int time = 0;
        int val = min( slots, time);
         System.out.println(val);
         System.out.println(Arrays.toString(slots));
    }
}
