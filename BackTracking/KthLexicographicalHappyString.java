package DSA500.BackTracking;

import java.util.ArrayList;

public class KthLexicographicalHappyString {
    private static int ans;
    private static String str;
    public static void backtrack(ArrayList<Character> ac,int n, int k){
        if(n==ac.size()){
            ans++;
            if(ans==k){
                for(Character c:ac){
                    str += c;
                }
            }
            return;
        }
        for(char ch = 'a'; ch <= 'c'; ++ch){
            if(ac.size()>0 && ac.get(ac.size()-1)==ch){
                continue;
            }
            ac.add(ch);
            backtrack(ac,n,k);
            if(ans==k)
                    return;
            ac.remove(ac.size()-1);
        }
        str = "";
    }
    public static void main(String[] args) {
        ArrayList<Character> ac = new ArrayList<>();
        int n = 1;
        int k = 3;
        ans = 0;
        str = "";
        backtrack(ac,n,k);
        System.out.println(str);
    }
}
