/*
2161. Partition Array According to Given Pivot
You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:

Every element less than pivot appears before every element greater than pivot.
Every element equal to pivot appears in between the elements less than and greater than pivot.
The relative order of the elements less than pivot and the elements greater than pivot is maintained.
More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
Return nums after the rearrangement.
 */
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
