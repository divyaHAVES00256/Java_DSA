import java.io.*;
import java.util.*;

class UsingSize {
        
    static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n) {
             
            for (int i = 0; i <= n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        public int findUPar(int node) {
            //ultimat root -> return
            if (node == parent.get(node)) {
                return node;
            }

            //else chamge currnt node parent to ultimate root
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            //find ultimate parent
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            //if ultimate parents are equal -> they must be conected
            if (ulp_u == ulp_v) return;
            

            //else find size
            //attach smaller size to the larger size
            //update size of the larger 
            //update paret of the smaller
            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
            }
        }

    }

    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
            ds.unionBySize(1, 2);
            ds.unionBySize(2, 3);
            ds.unionBySize(4, 5);
            ds.unionBySize(6, 7);
            ds.unionBySize(5, 6);

            // if 3 and 7 same or not
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");

            ds.unionBySize(3, 7);
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");

            //How to find conncted nodes?
            //using dsu to find clusters
            //only the ultimate root will have parent[i] = i;
            //so we simply need to count how many have parent[i]  i;
    }

}