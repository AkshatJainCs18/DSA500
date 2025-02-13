/*

Code
Testcase
Testcase
Test Result
3066. Minimum Operations to Exceed Threshold Value II
Solved
Medium
Topics
Companies
Hint
You are given a 0-indexed integer array nums, and an integer k.

In one operation, you will:

Take the two smallest integers x and y in nums.
Remove x and y from nums.
Add min(x, y) * 2 + max(x, y) anywhere in the array.
Note that you can only apply the described operation if nums contains at least two elements.

Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
 */

package DSA500.PriorityQueues;
import java.util.*;

public class ExceedThreshHold {
    public static void minOperations(int[] arr, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0 ; i<arr.length; ++i)
            pq.add((long)arr[i]);
        int ans =  0;
        while(pq.peek()<k){
            Long x = pq.poll();
            Long y = pq.poll();
            Long res = x*2 + y;
            pq.add(res);
            ans++;
        }
        System.out.println("Minimum operations = "+ans);
    }
    public static void main(String[] args) {
        int arr[] = {2,11,10,1,3};
        int k = 10;
        minOperations(arr,k);
    }
}