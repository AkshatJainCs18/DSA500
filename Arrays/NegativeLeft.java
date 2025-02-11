public class NegativeLeft {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void move(int arr[]){
        int l = 0 , r = arr.length - 1,mid = 0;
        while(mid <= r){
            if(arr[mid] < 0){
                NegativeLeft.swap(arr, l, mid);
                l++;
                mid++;
            }
            else if(arr[mid]> 0 && arr[r]>0){
                mid++;
            }
            else if(arr[mid]>0 && arr[r]<0){
                NegativeLeft.swap(arr, r, mid);
                r--;
            }

        }
        for (int e : arr)
            System.out.print(e + " ");

    }
    public static void main(String[] args)
    {
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, -9 };
        NegativeLeft.move(arr.clone());
//        for (int e : arr)
//            System.out.print(e + " ");
    }
}
