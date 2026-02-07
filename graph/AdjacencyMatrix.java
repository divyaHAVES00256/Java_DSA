public class AdjacencyMatrix {
    //print graph
    static void print(int graph[][]){
        System.out.print(" "  );
        for(int i = 0; i<graph.length; i++){
            System.out.print(" " +i );
        }
        System.out.println();
        int k = 0;
        for(int i[]: graph){
            System.out.print(k++ + " ");
            for(int j: i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //1. Adjacency Matrix for Undirected and Unweighted
    public static void add_edge_UU(int[][] mat, int i, int j){
        mat[i][j] = 1;
        mat[j][i] = 1; //since undirected both nodes form a edge
    }

    //2. Adjacency Matrix for directed and weighted
    public static void add_edge_DW(int[][] mat, int i, int j, int weight){
        mat[i][j] = weight;
        // mat[j][i] = 1; 
    }

    public static void main(String[] args){
        int V = 4; //4 nodes, start from the value 0 goes to 3
        int[][] mat = new int[V][V];

        add_edge_DW(mat, 0, 1, 4);
        add_edge_DW(mat, 1, 2, 3);
        add_edge_DW(mat, 1, 3, 2);
        add_edge_DW(mat, 2, 3, -1);

        print(mat);
    }

    
}
