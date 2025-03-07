/*
2523. Closest Prime Numbers in Range
Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].



Example 1:

Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.

 */
package DSA500.Math;

import java.util.Arrays;

public class ClosestPrimePairInRange {
    private static boolean[] sieve = new boolean[1000001];
    static {
        Arrays.fill(sieve,true);
        sieve[0] = sieve[1] = false;
        for(int i  = 2 ; i*i <= 1000000; ++i){
            if(sieve[i] == true){
                for(int j = 2*i; j <= 1000000; j += i){
                    sieve[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        int left = 19, right = 31;
        int first = -1;  int fi = -1;
        int second = -1; int si = -1;
        int[] ans = {-1,-1};
        int diff =Integer.MAX_VALUE;
        for(int i = left; i <= right; ++i){
            if(sieve[i] == true){
                if(first == -1) {first = i; fi = i;}
                else if(second == -1) {
                    second = i;
                    diff = second - first;
                    si = i;
                }
                else{
                    first = second; second = i;
                    if(second - first < diff){
                        diff = second - first;
                        fi = first;
                        si = second;
                    }
                }
            }
        }
        if(first == -1 || second == -1) System.out.println(ans[0] + " " + ans[1]);
        else {
            ans[0] = fi;
            ans[1] = si;
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
