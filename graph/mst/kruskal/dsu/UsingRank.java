import java.io.*;
import java.util.*;

class UsingRank {
        
    static class DisjointSet {
        int groups; //count connected componets
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n) {
            groups = n;
            for (int i = 0; i <= n; i++) {
                rank.add(0);
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

        public void unionByRank(int u, int v) {
            //find ultimate parent
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            //if ultimate parents are equal -> they must be conected
            if (ulp_u == ulp_v) return;

            //else find ultimate parent ranks
            //and connect sammler to larger

            //if rank are not euqal -> there is no way possible thier rank will be changed
            //hence only update parent of the smaller
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } 
            else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } 
            //rank is only changed when rank are equals
            //update parent of the smaller
            //update rank of the larger
            else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }

            groups--;
        }

    }

    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
            ds.unionByRank(1, 2);
            ds.unionByRank(2, 3);
            ds.unionByRank(4, 5);
            ds.unionByRank(6, 7);
            ds.unionByRank(5, 6);

            // if 3 and 7 same or not
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");

            ds.unionByRank(3, 7);
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");


            //How to find conncted nodes?
            //using dsu to find clusters
            //only the ultimate root will have find[i] = i;
            //so we simply need to count how many have find[i] = i;
    }

}