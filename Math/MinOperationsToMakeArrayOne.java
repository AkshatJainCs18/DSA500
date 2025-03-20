/*
3191. Minimum Operations to Make Binary Array Elements Equal to One I
You are given a binary array nums.

You can do the following operation on the array any number of times (possibly zero):

Choose any 3 consecutive elements from the array and flip all of them.
Flipping an element means changing its value from 0 to 1, and from 1 to 0.

Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.



Example 1:

Input: nums = [0,1,1,1,0,0]

Output: 3

Explanation:
We can do the following operations:

Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
 */
package DSA500.Math;

public class MinOperationsToMakeArrayOne {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0,0};
        int count  = 0;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == 0){
                if(i + 2 < arr.length){
                    count++;
                    arr[i] = 1;
                    arr[i + 1] ^= 1;
                    arr[i + 2] ^= 1;
                    continue;
                }
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(count);
    }
}
