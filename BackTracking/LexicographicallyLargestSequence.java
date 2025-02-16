/*
1718. Construct the Lexicographically Largest Valid Sequence
Solved
Medium
Topics
Companies
Hint
Given an integer n, find a sequence that satisfies all of the following:

The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.
Example 1:

Input: n = 3
Output: [3,1,2,3,2]
Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.
Example 2:

Input: n = 5
Output: [5,3,1,4,3,5,2,4,2]

We try to find the best number for a particular position, If that number is found, we try and look for the next position, and keep doing it until
we cannot find a valid number for a position OR we reach the end,
 */

package DSA500.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class LexicographicallyLargestSequence {
    public static boolean f(int []res,int []used,int pos, int n){
        if(pos==(2*n-1)) return true;
        else if(res[pos]!=0) return f(res,used,pos+1,n);
        else{
            for(int i =n; i>=1; --i){
                if(used[i]==1) continue;
                used[i] = 1;
                res[pos] = i;
                if(i==1 && f(res,used,pos+1,n))
                    return true;
                if(i>1 && (pos+i)<2*n-1 && res[pos+i]==0){
                    res[pos+i] = i;
                    if(f(res,used,pos+1,n))
                        return true;
                    res[pos+i] = 0;
                }
                used[i] = 0;
                res[pos] = 0;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int res[] = new int[2*n-1];
        int used[] = new int[n+1];
        boolean b = f(res,used,0,n);
       for(int i : res) System.out.print(i+" ");
    }
}
