/*
2467. Most Profitable Path in a Tree
class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length, maxIncome = Integer.MIN_VALUE;
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[n];
        Queue<int[]> nodeQueue = new LinkedList<>();
        nodeQueue.add(new int[] { 0, 0, 0 });
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // Form tree with edges
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // Find the path taken by Bob to reach node 0 and the times it takes to get there
        findBobPath(bob, 0);

        // Breadth First Search
        Arrays.fill(visited, false);
        while (!nodeQueue.isEmpty()) {
            int[] node = nodeQueue.poll();
            int sourceNode = node[0], time = node[1], income = node[2];

            // Alice reaches the node first
            if (
                !bobPath.containsKey(sourceNode) ||
                time < bobPath.get(sourceNode)
            ) {
                income += amount[sourceNode];
            }
            // Alice and Bob reach the node at the same time
            else if (time == bobPath.get(sourceNode)) {
                income += amount[sourceNode] / 2;
            }

            // Update max value if current node is a new leaf
            if (tree.get(sourceNode).size() == 1 && sourceNode != 0) {
                maxIncome = Math.max(maxIncome, income);
            }
            // Explore adjacent unvisited vertices
            for (int adjacentNode : tree.get(sourceNode)) {
                if (!visited[adjacentNode]) {
                    nodeQueue.add(new int[] { adjacentNode, time + 1, income });
                }
            }

            // Mark and remove current node
            visited[sourceNode] = true;
        }
        return maxIncome;
    }

    private Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> tree;

    // Depth First Search
    private boolean findBobPath(int sourceNode, int time) {
        // Mark and set time node is reached
        bobPath.put(sourceNode, time);
        visited[sourceNode] = true;

        // Destination for Bob is found
        if (sourceNode == 0) {
            return true;
        }

        // Traverse through unvisited nodes
        for (int adjacentNode : tree.get(sourceNode)) {
            if (!visited[adjacentNode]) {
                if (findBobPath(adjacentNode, time + 1)) {
                    return true;
                }
            }
        }
        // If node 0 isn't reached, remove current node from path
        bobPath.remove(sourceNode);
        return false;
    }
}
 */
package DSA500.Trees;
import java.util.*;
public class MostProfitablePath {
    private static HashMap<Integer,Integer> bobPath;
    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
        System.out.println(mp);
        int bobStart = 3 ;
        Integer[][]edges = {{0,1},{1,2},{1,3},{3,4}};
        for(int i=0; i<edges.length; ++i){
            if(!mp.containsKey(edges[i][0])){
                mp.put(edges[i][0],new ArrayList<>());
                mp.get(edges[i][0]).add(edges[i][1]);
                if(!mp.containsKey(edges[i][1])){
                    mp.put(edges[i][1],new ArrayList<>());
                    mp.get(edges[i][1]).add(edges[i][0]);
                }
            }
            else
            {
                mp.get(edges[i][0]).add(edges[i][1]);
                if(!mp.containsKey(edges[i][1])){
                    mp.put(edges[i][1],new ArrayList<>());
                    mp.get(edges[i][1]).add(edges[i][0]);
                }
            }
        }
        bobPath = new HashMap<>();
        bobPath.put(0,bobStart);

        System.out.println(mp);
    }
}
