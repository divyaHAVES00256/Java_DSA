import java.util.Arrays;

public class HashMap {
    int[] map;
    int size;
    public HashMap() {
        map = new int[1_000_001];
        size = 0;
        Arrays.fill(map, -1);
    }
    
    public void put(int key, int value) {
        if(!containsKey(key)) size++;
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
        size--;
    }

    public boolean containsKey(int key){
        if(map[key] == -1) return false;
        return true;
    }

    public int size(){
        return size;
    }
    public static void main(String args[]) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        // System.out.println(hashMap.get(1));
        // System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        // System.out.println(hashMap.get(2));
        hashMap.remove(2);
        hashMap.put(2, 3);
        hashMap.put(3, 1);
        hashMap.put(4, 1);
        // hashMap.get(1);
        System.out.println(hashMap.get(2));
       
        System.out.println( hashMap.size());
    }
}
