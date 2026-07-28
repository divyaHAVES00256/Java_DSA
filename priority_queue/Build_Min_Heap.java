import java.util.*;
public class Build_Min_Heap {

    // Constructor
    ArrayList<Integer> heap;
    int size;
    Build_Min_Heap() {
        // Initialize your data members
        heap = new ArrayList<>();
        size = 0;
    }

    public void push(int x) {
        // Insert x into the heap
        //add to the last
        //then fix it
        heap.add(x);
        
        //how to fix?
        int i = heap.size()-1;
        while(i > 0 && heap.get(parent(i)) > heap.get(i)){
            Collections.swap(heap, parent(i), i);
            i = parent(i);
        }
        
        size++;
    }
    
    int parent(int i){
        return (i-1)/2;
    }

    public void pop() {
        // Remove the top (minimum) element
        if(heap.size()<1) return;
        size--;
        
        //swap top with last
        // remove last
        //heapify on root?
        /*
        HEAPIFY(Peek Index = 0)
        1) left child
        2) right child
        3) min = min of left, right, par
        
        4) if current parent does not satisfy min heap(or parent is larger than any of the child)
        then we swap min and parent
        5) and heapify for min again
        */
        Collections.swap(heap, 0, heap.size()-1);
        heap.remove(heap.size()-1);
        if(size>0) heapify(0);
    }
    void heapify(int i){
        int l = (2*i+1);
        int r = (2*i+2);
        int min = i;
        
        //select min(i, left, right)
        //remember -> we must compare with min and l, r
        //why?
        //beacuse if left is min -> min = left
        //and in the next -> updated min by left is compared with right
        //but if we compare with 'i' -> updation by left will be vanished
        if(l<size && heap.get(l)<heap.get(min)) min = l;
        if(r<size && heap.get(r)<heap.get(min)) min = r;
        
        //do we need to heafify?
        //when i is not the minimum -> heapify is required
        if(i!=min){
            Collections.swap(heap, min, i);
            heapify(min);
        }
    }

    public int peek() {
        // Return the top element or -1 if empty
        if(heap.size()<1) return -1;
        return heap.get(0);
    }

    public int size() {
        // Return the number of elements in the heap
        return size;
    }
}