import java.util.PriorityQueue;

public class WeakestSoldier {
    static class Soldier implements Comparable<Soldier>{
        int count;
        int row;

        Soldier(int count, int row) {
            this.count = count;
            this.row = row;
        }

        @Override
        public int compareTo(Soldier s) {
            if(this.count == s.count) return this.row - s.row;

            return this.count - s.count;
        }

    }
    public static void main(String[] args) {
        
        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        int[][] soldiers = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 0, 0, 0}
        };

        for(int i = 0 ; i<soldiers.length; i++) {
            int count = 0;
            for(int j = 0; j<soldiers[0].length; j++) {
                if(soldiers[i][j] == 1) count++;
            }

            pq.add(new Soldier(count, i));
        }

        int k = 4;

        while(k>0) {
            System.out.println(pq.poll().row);
            k--;
        }
    }
}
