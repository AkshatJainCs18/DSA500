/*
rotate array by k steps.
first mod k by size of array to get final number of steps
then, reverse entire array.
now reverse first k elements of the reversed array
then reverse the remaining n-k elements of the reversed array
 */

public class RotateArray {
    public static void reverse(int arr[], int l, int r){
        while(l<r){
            arr[l] = arr[r] ^ arr[l];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[r--] ^ arr[l++];
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int k =2;
        int n = arr.length-1;
        k = k%arr.length;
        RotateArray.reverse(arr,0,n);
        RotateArray.reverse(arr,0,k-1);
        RotateArray.reverse(arr,k,n);
        for(int i: arr) System.out.print(i+" ");
    }
}
