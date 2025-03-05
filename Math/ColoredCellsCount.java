/*
2579. Count Total Number of Colored Cells
There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

At the first minute, color any arbitrary unit cell blue.
Every minute thereafter, color blue every uncolored cell that touches a blue cell.
Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.
Solution:
Basically for a given n, answer is Sum(first n odd)+Sum(first n-1 odd)
 */
package DSA500.Math;

public class ColoredCellsCount {
    public static void main(String[] args) {
        int n = 5;
        long res = (long)n*(long)n-- + (long)n*(long)n;
        System.out.println(res);
    }
}
