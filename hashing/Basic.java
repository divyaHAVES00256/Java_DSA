import java.util.HashMap;
public class Basic {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("America", 90);
        hm.put("japan", 80);
        hm.put("china", 70);

        System.out.println(hm.containsKey("china"));
        System.out.println(hm.containsKey("ram"));

        System.out.println(hm);
        System.out.println(hm.get("china"));
        System.out.println(hm.remove("china"));

        System.out.println(hm);
        System.out.println('a'-'z');
    }
}