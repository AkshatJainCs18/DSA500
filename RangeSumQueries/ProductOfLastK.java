/*
Leetcode 1352:
Basically range product queries of last k numbers in an arraylist.
to account for zero,if we find that previous number is zero, we just add the number normally to the array, otherwise, we take the previous number
multiply it with current number, and then add it.
we also maintain the latest index of the number zero, so when we get a query for finding product in a range of (n-k,n),
we can check if last zero falls in this range. if it  does ,return 0,
if arr[n-k]=0, then simply return arr[n];
otherwise return arr[n]/arr[n-k];
 */
package DSA500.RangeSumQueries;
import java.util.*;
class ProductOfNumbers {

    private ArrayList<Integer> l;
    private int lastZ = -1;
    public ProductOfNumbers() {
        this.l = new ArrayList<>();
    }

    public void add(int num) {
        if(l.isEmpty()) l.add(num);
        else{
            int end = l.getLast();
            if(end==0) l.add(num);
            else l.add(end*num);
        }
        if(num==0) this.lastZ = l.size()-1;
    }

    public int getProduct(int k) {
        int hi = l.size()-1;
        int lo = hi-k;
        if(lastZ==lo) return l.get(hi);
        else if(lastZ>=lo+1) return 0;
        else return l.get(hi)/l.get(lo);
    }
}
public class ProductOfLastK{
    public static void main(String[] args) {
        ProductOfNumbers p = new ProductOfNumbers();
        p.add(3);
        p.add(5);
        p.add(0);
        p.add(7);
        System.out.println(p.getProduct(2));
        p.add(8);
        System.out.println(p.getProduct(2));
    }
}