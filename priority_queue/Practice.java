import java.util.ArrayList;

public class Practice {
    private static ArrayList<Integer> list = new ArrayList<>();
    static class Heap{
        // int num;

        // Heap(int num){
        //     this.num = num;
        // }

        //insert
        public void add(int num) {
            // System.out.println("after " + list);

            if(list.isEmpty()){
                list.add(num);
                return;
            }
            list.add(num);
            int ch = list.size()-1;
            int par = (ch - 1)/2;

            while(par>=0 && list.get(ch)<list.get(par)){
                int temp = list.get(ch);
                list.set(ch, list.get(par));
                list.set(par, temp);

                ch = par;
                par = (ch - 1)/2;
                
            }
            
        }

        //peek
        public static int peek() {
            if(list.isEmpty()){
                System.out.println("empty heap");
                return -1;
            }
            return list.get(list.size()-1);
        }

        //remove (fifo ie root)
        public int remove() {
            if(list.isEmpty()){
                System.out.println("empty heap");
                return -1;
            }
            
            //swap 1st to last
            int temp = list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1, temp);
            
            //delete last
            int num = list.remove(list.size()-1);

            //heapify from root
            if(list.size()>1) heapify(0);
           
            return num;
        }
        static void heapify(int root){
            int lc = 2*root + 1;
            int rc = 2*root + 2;
            // if(lc>=list.size()) return; //stop when current node is leaf node

            int min = root;
            //left is min
            if(lc<list.size() && list.get(lc)<list.get(min)) {
                min = lc;
            }
            //right is min
            if(rc<list.size() && list.get(rc)<list.get(min)) {
                min = rc;
            }

            if(min == root) return; //or stop wwhen nothing is needed to stop ie child is larger than parent

            //swap min to par
            int temp = list.get(min);
            list.set(min, list.get(root));
            list.set(root, temp);
           
            //recurse
            heapify(min);
        }

        public boolean isEmpty() {
            if(list.size()>0) return false;
            return true;
        }
    }
    public static void main(String[] args) {
        Heap h1 = new Heap();
        h1.add(2);
        h1.add(3);
        h1.add(4);
        h1.add(5);
        h1.add(10);
        h1.add(1);
            System.out.println("bef " + list);


        while(!h1.isEmpty()){
                // System.out.println(h1.remove() + " ele ");
                System.out.println("afteryy " + list);
                h1.remove();
            }
    }
}
