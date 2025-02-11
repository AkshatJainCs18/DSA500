import java.util.*;
public class UnionArray {
    public static int findUnion(int a[], int b[]) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0 ; i <a.length; ++i){
            m.put(a[i],1);
        }
        for(int i = 0 ; i<b.length;++i){
            m.put(b[i],1);
        }
        return m.size();
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5}, b[] = {1,2,3};
        System.out.println(UnionArray.findUnion(a,b));


    }
}
