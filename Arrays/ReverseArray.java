public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int l = arr.length-1;
        for(int i = 0 ; i < arr.length/2; ++i){
            arr[i] = arr[i] ^ arr[l-i];
            arr[l-i] = arr[i] ^ arr[l-i];
            arr[i] = arr[i] ^ arr[l-i];
        }
        for(Integer i  :arr){
            System.out.println(i);
        }
    }
}
