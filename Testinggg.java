package DSA500;

import java.util.*;

public class Testinggg {
    private static boolean[] sieve = new boolean[1000001];
    static {
        Arrays.fill(sieve,true);
        sieve[0] = sieve[1] = false;
        for(int i  = 2 ; i*i <= 1000000; ++i){
            if(sieve[i] == true){
                for(int j = 2*i; j <= 1000000; j += i){
                    sieve[j] = false;
                }
            }
        }
    }
    public static boolean backtrack(int n,int x,HashMap<Integer,Integer> map){
        if(n==0)
            return true;
        if(n<0)
            return false;
        for(int i = x ; i>=0 ; --i){
            if(map.containsKey(i)){
                continue;
            }
             n -= (int)Math.pow(3,i);
             map.put(i,1);
             if(backtrack(n,x-1,map)){
                 return true;
             }
             else{
                 n += (int)Math.pow(3,i);
                 map.remove(i);
             }
        }
        return false;
    }
//    public static void testF(){
//       if(count == 0){
//           System.out.println("Inside static method");
//           arr = new int[2];
//           arr[0] = count+1;
//           arr[1] = count+2;
//           count++;
//       }
//    }
    public static void main(String[] args) {
        int left = 19, right = 31;
        int first = -1;  int fi = -1;
        int second = -1; int si = -1;
        int[] ans = {-1,-1};
        int diff =Integer.MAX_VALUE;
        for(int i = left; i <= right; ++i){
            System.out.println(i +" "+sieve[i]);
            if(sieve[i] == true){
                if(first == -1) {
                    System.out.println("first set as ="+i);first = i; fi = i;}
                else if(second == -1) {
                    second = i;
                    diff = second - first;
                    si = i;
                    System.out.println("second set as ="+i +"And difference set as "+ diff);
                }
                else{
                    first = second; second = i;
                    System.out.println("new first="+ first +" new second="+second + " current difference"+diff);
                    if(second - first < diff){
                        diff = second - first;
                        fi = first;
                        si = second;
                        System.out.println("new first="+ first +" new second="+second + " current difference"+diff);
                    }
                }
            }
        }
        if(first == -1 || second == -1) System.out.println(ans);
        ans[0] =fi; ans [1] = si;
        System.out.println(Arrays.toString(ans));
    }
}
