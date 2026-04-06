import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        //using multisource bfs
        //how is it bfs? -> if you look carefully everytime neigbourse of neighbours are rotted which is what bfs does
        //but whne we do dfs manuall time propogation nedded to be done which si such a hassle and not optimised but it will still work
        boolean chk[][] = new boolean[grid.length][grid[0].length];
        int total = 0; //total oranges
        int ans = 0; //time taken
        int empty = 0; //how many are 0

        Queue<int[]> q = new LinkedList<>(); //stores rotten 

        //initialise quue by insering all the rotten oragnes
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]!=0) total ++;
                if(grid[i][j]==2){
                    chk[i][j] = true;
                    q.add(new int[]{i, j});
                }

                //we added this condiion so that we do no analyze empty cell
                if(grid[i][j]==0){
                    chk[i][j] = true;
                    empty++;
                }
            }
        }

        

        int change = q.size(); //how many we changed
        
        while(!q.isEmpty()){
            //size tell currently we have size number rotten oranges which achtive neigbours are neddded to be processe all together in time t
            int size  = q.size();

            change+=size ; //how many are rotten are changed at once


            //chcek all the queue elements at a time t and insert its neigbour for the next 
            while(size!=0){
                int[] rem = q.poll();
                //left c+1
                if((rem[1]+1)<grid[0].length && chk[rem[0]][rem[1]+1] == false){
                    q.add(new int[]{rem[0], rem[1]+1});
                    chk[rem[0]][rem[1]+1] = true;
                }
                //right c-1
                if((rem[1]-1)>=0 && chk[rem[0]][rem[1]-1] == false){
                    q.add(new int[]{rem[0], rem[1]-1});
                    chk[rem[0]][rem[1]-1]  = true;
                }
                //top r-1
                if((rem[0]-1)>=0 && chk[rem[0]-1][rem[1]] == false){
                    q.add(new int[]{rem[0]-1, rem[1]});
                    chk[rem[0]-1][rem[1]] = true;
                }
                //bottom r+1
                if((rem[0]+1)<grid.length && chk[rem[0]+1][rem[1]] == false){
                    q.add(new int[]{rem[0]+1, rem[1]});
                    chk[rem[0]+1][rem[1]] = true;
                }

                size--;
            }
            if(!q.isEmpty()) ans++; //if queue has any elment tells us we need this to process in the next minut
            
        }
        
        if(empty==(grid.length*grid[0].length)) return 0; //all cell empty them answer will be 0
        if(change==total) return ans;
        return -1;
    }
}