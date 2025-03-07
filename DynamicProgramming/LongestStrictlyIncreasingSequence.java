/*
300. Longest Increasing Subsequence
Given an integer array nums, return the length of the longest strictly increasing subsequence.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
package DSA500.DynamicProgramming;

public class LongestStrictlyIncreasingSequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int n  = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i < arr.length; ++i){
            int mx = 0;
            for(int j = 0; j < i; ++j){
                if(arr[j]<arr[i] && dp[j]>mx)
                    mx = dp[j];
            }
            dp[i] = 1 + mx;
            if(dp[i]>ans) ans = dp[i];
        }
        System.out.println("Longest strict sequence is : "+ans);
    }
}
