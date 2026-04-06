import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K) {
        List<int []> edge = new ArrayList<>();

        for(int i = 0; i<dict.length-1; i++){
            String s = dict[i];
            String t = dict[i+1];

            for(int j = 0; j<Math.min(s.length(), t.length()); j++){
                char c = s.charAt(j);
                char r = t.charAt(j);
                if(c!=r) {
                    edge.add(new int[]{c-'a', r-'a'});
                    break;
                }
            }
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<K; i++){
            adj.add(new ArrayList<>());
        }

        for(int i[] : edge){
            adj.get(i[0]).add(i[1]);
        }


        //topo sort
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[K];

        for(int i = 0; i<K; i++){
            if(!vis[i]){
                dfs(i, vis, st, adj);
            }
        }

        // ArrayList<Integer> arr = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        char[] ch = new char[26];
        for (int i = 0; i < 26; i++) {
            ch[i] = (char) ('a' + i);
        }

        while(!st.isEmpty()){

            char c = ch[st.pop()];

            sb.append(c);
        }
        System.out.println(sb);

        return sb.toString();
    }

    public static void dfs(int i, boolean vis[], Stack<Integer> st, List<List<Integer>> adj){
        vis[i] = true;

        List<Integer> n = adj.get(i);
        for(int j : n){
            if(!vis[j]) {
                dfs(j, vis, st, adj);
            }
        }
        st.add(i);
    }
}
