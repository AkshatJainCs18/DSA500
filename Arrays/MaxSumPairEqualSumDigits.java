/* leetcode 2342 */
public class MaxSumPairEqualSumDigits {
    public int maximumSum(int[] arr) {
        HashMap<Integer,Integer> dm = new HashMap<>();
        int maxSum = -1;
        for(int i = 0;i<arr.length;++i){
            int sum = 0;
            int num = arr[i];
            //find sum of digits
            while(num>0) {
                sum += num%10;
                num/=10;
            }
            //if this sum of digits exists, find the value of that associated sum of digits, add to current element
            // and then check if greater than max sum. if yes, then replace max sum. Also check if current array value 
          // for this sum of digits is greater than the previously stored value. if yes, then replace.
            if(dm.containsKey(sum)){
                if(dm.get(sum)+arr[i] > maxSum)
                    maxSum = dm.get(sum) + arr[i];
                if(dm.get(sum) < arr[i])
                    dm.put(sum,arr[i]);
            }
              //if key doesnt exist, put it in the map.
            else
                dm.put(sum,arr[i]);
        }
        return maxSum;
    }
  public static void main(String args[]){
    int arr[] = {18,43,36,13,7};
    MaxSumPairEqualSumDigits obj =  new MaxSumPairEqualSumDigits();
    System.out.println(obj.maximumSum(arr));
  }
}
