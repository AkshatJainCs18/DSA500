import java.util.*;

public class Testinggg {
    public static void main(String[] args) {
        int[] arr = {-1,3,2,4,5};
        int k = 3;
        HashMap<Long,Integer> mp = new HashMap<>();
        long cum[] = new long[arr.length];
        cum[0]= (long)arr[0];
        for(int i = 0; i<arr.length; ++i){
            mp.put((long)arr[i],i);
            if(i>0)
                cum[i] = (long)arr[i] + cum[i-1];
        }
        System.out.println(mp);
        for(int i = 0; i<arr.length; ++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        long mxSum = 0;
        for(int i = 0; i<arr.length;++i){
            long key = (long)arr[i] +(long)k;
            System.out.println(key);
            if(mp.containsKey(key) && mp.get(key)>i){
                long sum;
                if(i==0) {
                    sum = cum[mp.get(key)];
                }
                else
                    sum = cum[mp.get(key)]-cum[i-1];
                mxSum = Math.max(mxSum,sum);
            }
        }
        System.out.println(mxSum);
    }
}
