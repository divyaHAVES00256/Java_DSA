import java.util.LinkedList;

public class HashMap2 {
    class HashMap<K, V>{ //<> these brackets are generic implementation, used when we do not know the datatypes in adavance
        class Node{
            K key;
            V val;

            Node(K key, V val){
                this.key = key;
                this.val = val;
            }
        }

        int size;
        LinkedList<Node> map[]; //array has ll elements

        //hashmap constructer
        @SuppressWarnings("unchecked")
        HashMap(){
            this.size = 0;
            this.map = new LinkedList[4]; //directyly writing ll without initializing type gives warning
            for (int i = 0; i < 4; i++) {
                this.map[i] = new LinkedList<>();
            }
        }

        //put
        void put(K key, V val){
            //bucket index
            //ll index
            
        }

    }
}
