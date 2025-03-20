/*
2606. Find the Substring With Maximum Cost
Solved
Medium
Topics
Companies
Hint
You are given a string s, a string chars of distinct characters and an integer array vals of the same length as chars.

The cost of the substring is the sum of the values of each character in the substring. The cost of an empty string is considered 0.

The value of the character is defined in the following way:

If the character is not in the string chars, then its value is its corresponding position (1-indexed) in the alphabet.
For example, the value of 'a' is 1, the value of 'b' is 2, and so on. The value of 'z' is 26.
Otherwise, assuming i is the index where the character occurs in the string chars, then its value is vals[i].
Return the maximum cost among all substrings of the string s.
 */
public class SubsStringMaxCost {
    public static void main(String[] args) {
        String s = new String("adaa");
        String chars = "d";
        int[] vals = {-1000};
        int[] freq = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        for(int i = 0 ; i<chars.length(); ++i){
            freq[chars.charAt(i)-'a'] = vals[i];
        }
        int mxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < s.length(); ++i){
            sum += freq[s.charAt(i)-'a'];
            if(sum>mxSum) mxSum = sum;
            if(sum<0) sum = 0;
        }
        if(mxSum <0) mxSum = 0;
        System.out.println(mxSum);
    }
}
