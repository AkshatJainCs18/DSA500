/*

Code
Testcase
Testcase
Test Result
26. Remove Duplicates from Sorted Array
Solved
Easy
Topics
Companies
Hint
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
 */
public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        int[] arr =  {0,0,1,1,1,2,2,3,3,4,5,5,6};
        int j  = 1;
        int initC = 1;
        for(int i = 1; i<arr.length; ++i){
            if(arr[i]==arr[i-1]){
                if(initC<2){
                    initC = 2;
                    j++;
                }
                else j=i;
            }
            else{
                initC = 1;
                arr[j] = arr[i];
                j++;
            }

        }

        System.out.println(j);
    }
}
