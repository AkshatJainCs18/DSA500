/*
Program to sort an array of 0,1, and 2 such that its done in O(n) time and O(1)  space.
One way is two pass approach by counting all 0 1 and 2.
Other way is using dutch flag algo, where we use 3 pointers, lo,mid, and hi.
arr[0] - arr[lo-1] contains all 0's
arr[lo]- arr[mid-1] contains all 1's
arr[mid]- arr[high] contains all 2's
run a loop till mid<=high, if 0 is found, swap lo and mid, and increment both by 1.
if 1 is found, just increment mid.
if 2 is found, swap mid and high and decrement hi by 1.
 */
public class Sort012 {
    public static void naive(int arr[]){
        int c1 = 0, c2 = 0, c3 = 0;
        for (int j : arr) {
            c1 += j == 0 ? 1 : 0;
            c2 += j == 1 ? 1 : 0;
            c3 += j == 2 ? 1 : 0;
        }
        for(int i = 0 ; i<arr.length; ++i){
            if(c1-->0) arr[i] = 0;
            else if(c2-->0) arr[i] = 1;
            else arr[i] = 2;
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void dutchFlag(int arr[]){
            int lo = 0, hi = arr.length - 1, mid = 0;
            while(mid<=hi){
                if(arr[mid]==0) {
                    Sort012.swap(arr,mid,lo);
                    lo++; mid++;
                }
                else if(arr[mid]==1){
                    mid++;
                }
                else if(arr[mid]==2){
                    Sort012.swap(arr,mid,hi);
                    hi--;
                }
            }
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String args[]) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        Sort012.naive(arr.clone());
        Sort012.dutchFlag(arr.clone());
    }
}
