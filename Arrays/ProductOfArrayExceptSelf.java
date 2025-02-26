public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int l = nums.length;
        int[] right = new int[l];
        right[l-1] = nums[l - 1];

        for(int i = l-2; i>=0; --i){
            right[i] = nums[i] * right[i+1];
        }
        for(int i = 1; i<l; ++i){
            nums[i] = nums[i] * nums[i-1];
        }
        int[] ans = new int[l];
        for(int i = 1; i<l-1; ++i){
            ans[i] = nums[i-1] * right[i+1];
        }
        ans[0] = right[1];
        ans[l-1] = nums[l-2];
        for(int i  = 0; i<l ;++i){
            System.out.println(nums[i] + " "+ right[i]);
        }
    }
}
