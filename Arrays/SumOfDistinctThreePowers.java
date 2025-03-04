/*


1780. Check if Number is a Sum of Powers of Three
Solved
Medium
Topics
Companies
Hint
Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3x.
 */
public class SumOfDistinctThreePowers {
    public static void main(String[] args) {
        int n = 7627;
        int x = (int)Math.floor(Math.log(n)/Math.log(3));
        while (n > 0 && x >= 0) {
            int  diff = (int) Math.pow(3, x--);
            if (diff <= n) {
                n -= diff;
            }
        }
        System.out.println(n==0);
    }
}
