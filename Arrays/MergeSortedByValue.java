/*


2570. Merge Two 2D Arrays by Summing Values

You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.
 */
import java.util.*;
public class MergeSortedByValue {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{4,5}};
        int[][] brr = {{1,4},{3,2},{4,1}};
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int[] ints : arr) {
            mp.put(ints[0], ints[1]);
        }
        for (int[] ints : brr) {
            if (mp.containsKey(ints[0]))
                mp.put(ints[0], mp.get(ints[0]) + ints[1]);
            else
                mp.put(ints[0], ints[1]);
        }
        System.out.println(mp);
        int[][] ans = new int[mp.size()][2];
        int i = 0, j = 0, k = 0 , la = arr.length, lb = brr.length;
        while(i < la && j < lb){
            if(arr[i][0] == brr[j][0]){
                ans[k][0] = arr[i][0];
                ans[k][1] = mp.get(arr[i][0]);
                k++; i++; j++;
            }
            else if(arr[i][0] < brr[j][0]){
                ans[k][0] = arr[i][0];
                ans[k][1] = arr[i][1];
                k++; i++;
            }
            else {
                ans[k][0] = brr[j][0];
                ans[k][1] = brr[j][1];
                k++; j++;
            }
        }
        while(i < la){
            ans[k][0] = arr[i][0];
            ans[k][1] = arr[i][1];
            k++; i++;
        }
        while(j < lb) {
            ans[k][0] = brr[j][0];
            ans[k][1] = brr[j][1];
            k++;
            j++;
        }
        System.out.println(Arrays.toString(ans));
    }
}
