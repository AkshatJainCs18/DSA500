package DSA500.DynamicProgramming;
/*
1092. Shortest Common Supersequence

Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
Solution:
At every point we have a choice, picking one character from a or b. So if we pick from a, move a pointer forward,
if we pick from b, move b forward. When we reach the end of either a or b, then we have our answer.
Dynamic Programming table has been constructor from this approach bottom up.


 */
public class ShortestSupersequence {
    public static void main(String[] args) {
        String a = "abac";
        String b = "cba";
        int n = a.length(), m = b.length();
        int dp[][] = new int[n+2][m+2];
        dp[n][m] = 0;
        for(int i = 0; i<m+2; ++i) dp[n+1][i] = 42069;
        for(int i = 0; i<n+2; ++i) dp[i][m+1] = 42069;
        for(int i = 0; i<m; ++i) dp[n][i] = m-i;
        for(int i = 0; i<n; ++i) dp[i][m] = n-i;
        for(int i = n-1; i>=0; --i){
            for(int j = m-1; j>=0; --j){
                if(a.charAt(i)==b.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = 1 + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        StringBuilder temp = new StringBuilder("");
        int i , j ;
        i = j = 0;
        while(dp[i][j]!=0){
            if(i!=n && j!=m && a.charAt(i)==b.charAt(j)){
                temp.append(a.charAt(i));
                i++; j++;
            }
            else if(dp[i+1][j]<dp[i][j+1]){
                temp.append(a.charAt(i));
                i++;
            }
            else {
                temp.append(b.charAt(j));
                j++;
            }
        }
        System.out.println(temp);
    }
}
