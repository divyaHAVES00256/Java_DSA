import java.util.*;
public class HashSet1 {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(0);
        set.add(0);
        set.add(10);
        set.add(-10);

        System.out.println(set);
    }
}
