/*
1980. Find Unique Binary String
Solved
Medium
Topics
Companies
Hint
Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.



Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.
 */
package DSA500.BackTracking;
import java.util.*;
public class FindUniqueBinaryString {
    public static void backtrack(int l,int[] flag,HashMap<String,Integer> m,StringBuilder temp){
        if(l==0){
            if(!m.containsKey(temp.toString())){
                flag[0] = 1;
            }
            return;
        }
        for(char c = '0'; c <= '1'; ++c){
            temp.append(c);
            backtrack(l-1,flag,m,temp);
            if(flag[0]==1)
                return;
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public static void main(String[] args) {
        String[] nums= {"111","011","001"};
        HashMap<String, Integer> m = new HashMap<>();
        for(String i : nums)
            m.put(i,1);
        int flag[]={0};
        StringBuilder temp = new StringBuilder("");
        backtrack(nums[0].length(),flag,m,temp);
        System.out.println(temp.toString());

    }
}
