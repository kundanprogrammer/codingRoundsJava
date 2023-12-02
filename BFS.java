import java.util.*;
public class Solution {
	public static ArrayList<Integer> BFS(int vertex, int edges[][]){
		ArrayList<TreeSet<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<vertex;i++){
            adjList.add(new TreeSet<Integer>());
        }
        
        for(int j=0;j<edges[0].length;j++){
            adjList.get(edges[0][j]).add(edges[1][j]);
        }
        for(int j=0;j<edges[1].length;j++){
            adjList.get(edges[1][j]).add(edges[0][j]);
        }        
        
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[vertex];
        
        for(int i=0;i<vertex;i++){
            if(!vis[i]){
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);
                    for (Integer cur: adjList.get(node)) {
                        if (!vis[cur]) {
                            vis[cur] = true;
                            q.add(cur);
                        }
                    }
                }
            }
        }
        return bfs;
	}
}