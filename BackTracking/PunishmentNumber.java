/*

Code
Testcase
Testcase
Test Result
2698. Find the Punishment Number of an Integer
Solved
Medium
Topics
Companies
Hint
Given a positive integer n, return the punishment number of n.

The punishment number of n is defined as the sum of the squares of all integers i such that:

1 <= i <= n
The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer values of these substrings equals i.
Input: n = 10
Output: 182
Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
- 1 since 1 * 1 = 1
- 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
- 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
Hence, the punishment number of 10 is 1 + 81 + 100 = 182
 */
package DSA500.BackTracking;

public class PunishmentNumber {
    private static int log;
    public static boolean isValid(int sq,int rem){
        if(rem==0 && sq==0) return true;
        if(sq==0) return false;
        for(int i=1;i<=log;++i){
            int dig = sq % (int)(Math.pow(10,i));
            int csq = sq / (int)(Math.pow(10,i));
            if(isValid(csq,rem-dig))
                return true;
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int ans = 0;

        for(int i =1; i<=n; ++i){
            log = (int) Math.log10(Math.abs(i)) + 1;
            ans += isValid(i*i,i)? i*i:0;
        }
        return ans;
    }
    public static void main(String[] args) {
            PunishmentNumber p = new PunishmentNumber();
        System.out.println(p.punishmentNumber(10));
    }
}
