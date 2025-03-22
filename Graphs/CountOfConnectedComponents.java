package DSA500.Graphs;
import java.util.*;
/*
2685. Count the Number of Complete Components
You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.
 Example : n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all the components of this graph are complete.
 */
public class CountOfConnectedComponents {
    private static int valid;
    public static void dfs(int curr, HashMap<Integer,List<Integer>> adj, HashMap<Integer,List<Integer>> compMap, int comp , boolean[] vis){
        if(!vis[curr]){
            vis[curr] = true;
            compMap.get(comp).add(curr);
            valid = valid == -1 ? adj.get(curr).size() : (adj.get(curr).size() != valid ? 0 : valid);
            for(int i = 0; i < adj.get(curr).size(); ++i){
                if(!vis[adj.get(curr).get(i)])
                    dfs(adj.get(curr).get(i), adj, compMap , comp , vis);
            }
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; ++i)
            adj.put(i,new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int ans = 0;
        HashMap<Integer,List<Integer>> compMap = new HashMap<>();
        boolean[] vis = new boolean[n];
        int compCount = 0;
        for(int i = 0; i < n; ++i){
            if(!vis[i]){
                valid = -1;
                compMap.put(compCount,new ArrayList<>());
                dfs(i , adj , compMap , compCount , vis);
                ans += compMap.get(compCount).size() - 1 == valid ? 1 : 0;
                compCount++;
            }
        }
        System.out.println(ans);
    }
}
