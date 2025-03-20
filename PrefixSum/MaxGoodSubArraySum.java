/*
Solution:
Basically, a good subarray will end at arr[i] IFF
we can find arr[i]-k or arr[i]+k exists in our array
so far.
On top of that,lets say any of those values do exist
in our array.
The way to check for this would be to store every arr[i]
inside a map. Now the question would be , what will be the value if key is arr[i].
Moreover, how to get the same from current index i till the previous index of arr[i]-k or arr[i]+k.
Lets say k = 3, and array looks like this:
_ _ _ 5 _ _ 5 _ 8. So 8-3 = 5. And 5 exists in our array..twice before 8.
What we can do is, we can store the prefix sum of all elements upto, but excluding, 5.
But question is, which prefix sum to store, the one for first 5, or for second 5.
We just need to store prefix sum for the 5 which has the least prefix sum, as that would help us in
maximising the sum of the subarray,which we can calculate as curr(sum of all elements including arr[i])-prefixSumUpto(5);


3026. Maximum Good Subarray Sum

You are given an array nums of length n and a positive integer k.

A subarray of nums is called good if the absolute difference between its first and last element is exactly k, in other words, the subarray nums[i..j] is good if |nums[i] - nums[j]| == k.

Return the maximum sum of a good subarray of nums. If there are no good subarrays, return 0.
 */
package DSA500.PrefixSum;

import java.util.HashMap;

public class MaxGoodSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-1,3,2,4,5};
        int k = 3;
        HashMap<Integer,Long> mp = new HashMap<>();
        long curr = 0L;
        long res = Long.MIN_VALUE;
        for(int i =0 ; i<arr.length;++i) {
            if(!mp.containsKey(arr[i]))
                mp.put(arr[i],curr);
            else
                mp.put(arr[i],Math.min(mp.get(arr[i]),curr));
            curr += (long)arr[i];
            if(mp.containsKey(arr[i]-k))
                res = Math.max(res,curr-mp.get(arr[i]-k));
            if(mp.containsKey(arr[i]+k))
                res = Math.max(res,curr-mp.get(arr[i]+k));
        }
        System.out.println(res!=Long.MIN_VALUE?res:0);
    }
}
