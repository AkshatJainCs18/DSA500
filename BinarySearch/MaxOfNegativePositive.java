/*
2529. Maximum Count of Positive Integer and Negative Integer
Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.



Example 1:

Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
 */
package DSA500.BinarySearch;

public class MaxOfNegativePositive {
    public static int getIndex(int[] arr, int l, int r,int sgn){
        while(l <= r){
            int mid = l + (r - l)/2;
            if(sgn == 0){
                if(arr[mid] > 0){
                    if(mid == 0 || arr[mid-1] <= 0) return mid;
                    else r = mid - 1;
                }
                else l = mid + 1;
            }
            else{
                if(arr[mid] < 0){
                    if(mid == arr.length - 1 || arr[mid + 1] >= 0) return mid;
                    else l = mid + 1;
                }
                else r = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {-2,-1,-1,-1,-1,1,2,3,4};
        int pos_i = getIndex(arr,0,arr.length-1,0);
        int neg_i = getIndex(arr,0,arr.length-1,1);
        int pos_count = pos_i == -1 ? 0 : arr.length - pos_i;
        int neg_count = neg_i == -1 ? 0 : neg_i+1;
        System.out.println(pos_count > neg_count ? pos_count : neg_count);
    }
}
