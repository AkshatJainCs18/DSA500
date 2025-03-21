/*
2115. Find All Possible Recipes from Given Supplies
You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.
Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
 */
package DSA500.Graphs;
import java.util.*;
public class PossibleRecipes {
    public static void main(String[] args) {
        String[] rec = {"bread","sandwich","burger"};
        String[][] ing = {{"yeast","flour"},{"bread","meat"},{"sandwich","meat","bread"}};
        String[] sup = {"yeast","flour","meat"};
        HashMap<String, List<String>> adj = new HashMap<>();
        HashMap<String,Integer> degree = new HashMap<>();
        for(int i = 0; i < rec.length; ++i){
            degree.put(rec[i],ing[i].length);
            for(String currIng : ing[i]){
                adj.putIfAbsent(currIng,new ArrayList<>());
                adj.get(currIng).add(rec[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for(String currSupply : sup)
            q.add(currSupply);
        while(q.size() > 0){
            String currSupply  = q.poll();
            if(adj.containsKey(currSupply)){
                for(String next : adj.get(currSupply)){
                    int count = degree.get(next) - 1;
                    if(count == 0){
                        ans.add(next);
                        q.add(next);
                    }
                    else
                        degree.put(next,count);
                }
            }
        }
        System.out.println(ans);
    }
}
