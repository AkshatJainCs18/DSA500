import java.util.*;

/*
Find the kth smallest and/or largest element in an unsorted array
 */
 class NaiveApproach {
    public static void KthSmallest(Integer[] arr, int k) {
        for(int i  = 0 ; i < k; ++i){
            int min_index = i;
            for(int j = i + 1 ; j < arr.length; ++j){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        System.out.println(k+"th smallest element is "+arr[k-1]);
    }
}
class MinHeapApproach{
     public static void KthSmallest(Integer[] arr, int k) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();
         for(int i = 0; i<arr.length; ++i){
             pq.add(arr[i]);
         }
         for(int i = 1; i<k; ++i)
             pq.poll();
         System.out.println(k+"th smallest element is " + pq.peek());
     }
}
class MaxHeapApproach{
     public static void KthSmallest(Integer[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0 ; i<arr.length; ++i){
            if(i<k) pq.add(arr[i]);
            else {
                if(pq.peek() > arr[i]) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }
         System.out.println(k+"th smallest element is " + pq.peek());
     }
}
public class KthSmallest {
    public static void main(String[] args) {
        Integer arr[] = {7, 10, 4, 20, 15}, k = 4;
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        NaiveApproach.KthSmallest(arr.clone(),k);
        MinHeapApproach.KthSmallest(arr.clone(),k);
        MaxHeapApproach.KthSmallest(arr.clone(),k);
        //System.out.println(list);
    }
}
