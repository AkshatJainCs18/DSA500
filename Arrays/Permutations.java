import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    private static void swap(Integer[]arr, int i,int j){
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
    public static void permute2(Integer[] arr,int l,int r, List<List<Integer>> ans){

        if(l==r){
            if (l == 0 || (arr[l] % 2 != arr[l - 1] % 2)) {
                ans.add(new ArrayList<>(Arrays.asList(arr)));

            }
            return;

        }
        for(int i = l ; i <= r ; ++i){
            swap(arr,i,l);
            if (l == 0 || (arr[l] % 2 != arr[l - 1] % 2)) {
                permute2(arr, l + 1, r, ans);
            }
            swap(arr,i,l);
        }
    }
    public static void main(String[] args) {
        int[] crr = {1,2,3,4};
        int len = crr.length;
        int l = 0;
        int r = len-1;
        List<List<Integer>> ans= new ArrayList<>();
        Integer[] arr = new Integer[len];
        for(int i = 0; i < len; ++i){
            arr[i] = crr[i];
        }
        permute2(arr,l,r,ans);
        System.out.println(ans);

    }
}
