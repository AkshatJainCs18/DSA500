/*
2594. Minimum Time to Repair Cars
You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.

You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.

Return the minimum time taken to repair all the cars.

Note: All the mechanics can repair the cars simultaneously.
Input: ranks = [4,2,3,1], cars = 10
Output: 16
Explanation:
- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.
 */
package DSA500.BinarySearch;

public class MinimumTimeToRepairCars {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1};
        int cars = 10;
        long l = 1, r = Long.MAX_VALUE ,ans = arr[0],k = (long)cars;
        outer : while(l <= r){
            long count  = 0 , mid = l + (r - l) / 2;
            for(int i : arr){
                count += (long)(Math.sqrt(mid/i));
                if(count >= k) {
                    ans = r = --mid;
                    continue outer;
                }
            }
            l = mid + 1;
        }
        System.out.println(++ans);
    }
}
