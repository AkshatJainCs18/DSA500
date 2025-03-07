package DSA500.DynamicProgramming;

public class CountLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};
        int n  = arr.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        dp[0] = count[0] = 1;
        int ans = 1;
        for(int i = 1; i < arr.length; ++i){
            int mx = 0;
            int c = 1;
            for(int j = 0; j < i; ++j){
                if(arr[j] < arr[i]){
                    if(dp[j] > mx){
                        mx = dp[j];
                        c = count[j];
                    }
                    else if(dp[j] == mx){
                        c += count[j];
                    }
                }
            }
            count[i] = c;
            dp[i] = 1 + mx;
            if(dp[i]>ans)
                ans = dp[i];
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] == ans) {
                res += count[i];
            }
        }
        System.out.println("Number of longest increasing subsequence: " + res);
    }
}
