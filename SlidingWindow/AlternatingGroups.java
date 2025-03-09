package DSA500.SlidingWindow;

public class AlternatingGroups {
    public static void main(String[] args) {
        int[] arr = {0,1,0,0,1,0,1};
        int k = 6;
        int count = 0;
        int n = arr.length;
        int l = 0;
        int end = n + k - 1;
        for(int r = 1; r < end; r++){
            if(arr[r%n] == arr[(r-1)%n]){
                l = r;
            }
            if(r - l + 1 > k){
                l++;
            }
            if(r - l + 1 == k){
                count++;
            }
        }
        System.out.println(count);
    }
}
