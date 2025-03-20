package DSA500.SlidingWindow;
/*
2461. Maximum Sum of Distinct Subarrays With Length K

You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.
 */
import java.util.HashMap;

public class MaxSumKSizeSubArrayDistinct {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9};
        int k = 3;
        HashMap<Integer,Integer> mp = new HashMap<>();
        long curr = 0 ;
        int winStart = 0;
        long mxSum = 0;
        for(int i = 0; i<arr.length; ++i){
            curr += arr[i];
            if(mp.containsKey(arr[i])){// && mp.get(arr[i])>=winStart){
                while(winStart<mp.get(arr[i]) + 1){
                    curr -= arr[winStart];
                    winStart++;
                }
            }
            if(i-winStart+1==k){
                mxSum = Math.max(mxSum,curr);
                curr -= arr[winStart];
                winStart++;
            }
            mp.put(arr[i],i);
        }
        System.out.println(mxSum);
    }
}
