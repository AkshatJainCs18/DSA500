/*
Solution:
The size of answer will always be s.length() +1, ranging in [1..s.length()+1]
Push the current number into the  stack ONLY if you find 'D', and keep pushing until we find 'I'.
When we find I, we pop the numbers from the stack and concatenate them into the answer.
2375. Construct Smallest Number From DI String

You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

num consists of the digits '1' to '9', where each digit is used at most once.
If pattern[i] == 'I', then num[i] < num[i + 1].
If pattern[i] == 'D', then num[i] > num[i + 1].
Return the lexicographically smallest possible string num that meets the conditions.



Example 1:

Input: pattern = "IIIDIDDD"
Output: "123549876"
Explanation:
At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.
Example 2:

Input: pattern = "DDD"
Output: "4321"
Explanation:
Some possible values of num are "9876", "7321", and "8742".
It can be proven that "4321" is the smallest possible num that meets the conditions.
 */
package DSA500.Stacks;

import java.util.Stack;

public class SmallestNumberFromDIString {
    public String smallestNumber(String s) {
        Stack<String> st = new Stack<>();
        int a = 1;
        int f = 0;
        String ans = "";
        for(int i =0; i<s.length(); ++i,a++){
            if(s.charAt(i)=='I'){
                ans += Integer.toString(a);
                if(f!=0){
                    f=0;
                    while(!st.isEmpty()){
                        ans += st.pop();
                    }
                }
            }
            else {
                f=1;
                st.push(Integer.toString(a));
            }
        }
        ans += Integer.toString(a); // adding the last number(s.length()+1) onto the stack
        while(!st.isEmpty()){ //if in case something is pending in the stack, adding it onto the answer.
            ans += st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestNumberFromDIString().smallestNumber("IIIDIDDD"));
    }
}
