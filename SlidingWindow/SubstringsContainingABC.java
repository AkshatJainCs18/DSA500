/*
1358. Number of Substrings Containing All Three Characters
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again)
 */
package DSA500.SlidingWindow;

public class SubstringsContainingABC {
    public static void main(String[] args) {
        String s = "abcabc";
        int[] chars = {0,0,0};
        int ans  = 0;
        int left = 0;
        for(int i = 0; i < s.length(); ++i){
            chars[s.charAt(i) - 'a']++;
            while(chars[0]>0 && chars[1]>0 && chars[2]>0){
                ans += s.length() - i;
                chars[s.charAt(left++) - 'a']--;
            }
        }
        System.out.println(ans);
    }
}
