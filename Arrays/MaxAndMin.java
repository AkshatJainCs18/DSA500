//maximum and minimum elements in an array using tournament method
/*
Basically, compare elements in pairs. If number of elements is odd, assign max and min as the starting element.
Otherwise , assign max and min as the maximum and minimum of the first two elements.
In case of odd, first element is covered. now take remaining n-1= even number of elements and make 3 comparisons:
1. First comparison to see which is bigger in the taken pair.
2. Second comparison to assign to max
3. Third comparison to assign to even
 */
public class MaxAndMin {
    public static void main(String[] args) {
        int arr[] = {4,5,32,13,3,4,5,1,23,5,6};
        int l = arr.length;
        int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int i;
        if(l%2==0){
            i = 2;
           if(arr[0]>arr[1]){
               max = arr[0];
               min = arr[1];
           }
           else{
               max = arr[1];
               min = arr[0];
           }
        }
        else{
            i = 1;
            max = min = arr[0];
        }
        for(; i<l-1;i+=2){
            if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i + 1]);
            } else {
                max = Math.max(max, arr[i + 1]);
                min = Math.min(min, arr[i]);
            }
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
