/*
2467.
 */
package DSA500.Trees;
import java.util.*;
public class MostProfitablePath {
    private static HashMap<Integer,Integer> bobPath;
    private static int Parent;
    private static int maxProfit;
    public static void findAlexProfit(HashMap<Integer, ArrayList<Integer>> mp, int currNode, int parent, int dist, int[] amount, int currProfit) {
        // Check if it's a leaf node
        if (mp.get(currNode).size() == 1 && parent == mp.get(currNode).get(0)) {
            maxProfit = Math.max(currProfit, maxProfit);
            return;
        }

        for (Integer nextNode : mp.get(currNode)) {
            if (nextNode == parent) continue; // Prevent backtracking

            int newProfit = currProfit;

            if (bobPath.containsKey(nextNode)) {
                if (bobPath.get(nextNode) == dist + 1) {
                    newProfit += amount[nextNode] / 2;
                }
            } else {
                newProfit += amount[nextNode];
            }

            findAlexProfit(mp, nextNode, currNode, dist + 1, amount, newProfit);
        }
    }
    public static boolean findBobPath(HashMap<Integer,ArrayList<Integer>> mp, int currNode, int dist){
        if(currNode == 0){
            return true;
        }
        if(mp.get(currNode).size()==1 && Parent==mp.get(currNode).getFirst())
            return false;
        ArrayList<Integer> list = mp.get(currNode);
        for(Integer i : list){
            bobPath.put(i,dist+1);
            Parent = i;
            if(findBobPath(mp,i,dist+1)){
                return true;
            }
            bobPath.remove(i);
        }
        return false;
    }


    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
        int bobStart = 1 ;
        int[][]edges = {{0,3},{0,4},{1,3},{1,2}};//,{3,4}};
        for (int[] edge : edges) {
            mp.putIfAbsent(edge[0], new ArrayList<>());
            mp.putIfAbsent(edge[1], new ArrayList<>());
            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);
        }
        bobPath = new HashMap<>();
        bobPath.put(bobStart,0);
        Parent = bobStart;
        findBobPath(mp,bobStart,0);
        maxProfit = Integer.MIN_VALUE;
        int[] amount = {-2,4,2,-4,6};
        findAlexProfit(mp, 0, -1, 0, amount, amount[0]);
        System.out.println(mp);
        System.out.println(bobPath);
        System.out.println(maxProfit);
    }
}
