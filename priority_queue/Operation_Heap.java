import java.util.ArrayList;

public class Operation_Heap {
    static class Heap {
        public static ArrayList<Integer> arr = new ArrayList<>();
        
        //insert
        public void add(int data){
            //add
            arr.add(data);

            //fix
            int c = arr.size()-1;
            int p = (c-1)/2;

            //if child is smaller => fix
            while(c>0 && arr.get(c)<arr.get(p)){
                int temp = arr.get(c);
                arr.set(c, arr.get(p));
                arr.set(p, temp);

                c = p;
                p = (c-1)/2;
            }

            System.out.println(arr);
        }

        //peek
        public static int peek(){
            if(arr.size()<=0) return -1;
            return arr.get(0);
        }

        //delete(fifo, delete root)
        public int remove(){
            if(arr.size()<=0) return -1;

            //swap l to f
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // System.out.println(arr.get(0) + " rem " + arr.get(arr.size()-1));

            //remove last
            int ele = arr.remove(arr.size()-1);

            //heapify on root
            heapify(0);

            return ele;//root
        }
        private static void heapify(int i) {
            // System.out.println(arr);
            int l = 2*i+1; //left child
            int r = 2*i+2; //right child

            int  minidx = i;

            //left is min
            if(l<arr.size() && arr.get(l)<arr.get(minidx)) {
                minidx = l;
            }

            //right is min
            if(r<arr.size() && arr.get(r)<arr.get(minidx)) {
                minidx = r;
            }

            // System.out.println(" l " + l + " r " + r+ " minidx " + minidx + " i " + arr.get(i));

            if(minidx!=i){ //when no element left
                //swap min(l or r) to root
                int temp = arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);
                
                heapify(minidx);
            }
        }

        public boolean isEmpty() {
            if(arr.size()>0) return false;
            return true;
        }
        static {
            System.out.println(arr);
        }

    }

    public static void main(String[] args) {
        Heap h1 = new Heap();
        h1.add(2);
        h1.add(3);
        h1.add(4);
        h1.add(5);
        h1.add(10);
        h1.add(6);
        // while(!h1.isEmpty()){
        //     System.out.println(h1.remove() + " hh ");
        // }
        // h1.remove();
            // System.out.println(h1.remove() + " hh ");

            while(!h1.isEmpty()){
                System.out.println(h1.remove() + " uu ");
            }
    }
}
