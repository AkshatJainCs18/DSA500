import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.Consumer;

public class ParitionAroundPivot {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        int copy[] = new int[nums.length];
        int li = 0, ei,gi ;
        for (int j : nums) {
            if (j < pivot)
                copy[li++] = j;
        }
        ei = li;
        for (int num : nums) {
            if (num == pivot)
                copy[ei++] = num;
        }
        gi = ei;
        for (int num : nums) {
            if (num > pivot)
                copy[gi++] = num;
        }
        Consumer<Integer> c = x -> System.out.println(x);
        Arrays.stream(copy).boxed().forEach(c);
    }
}
