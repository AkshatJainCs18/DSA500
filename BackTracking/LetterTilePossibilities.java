/*
1079. Letter Tile Possibilities

You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.



Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1

Solution:
Try making a trie for visualisation, it will use a character frequency array to store the frequency of each character. when adding a node
to the tree, decrease its frequency. Once returning, increase the frequency back up to make it usable  for other calls.
 */

package DSA500.BackTracking;

public class LetterTilePossibilities {
    private int ans;
    public void insert(int arr[]) {
        for(int i = 0;i<26;++i){
            if(arr[i]!=0){
                arr[i]--;
                ans++;
                insert(arr);
                arr[i]++;
            }
        }
        return;
    }
    public int numTilePossibilities(String s) {
        int[] arr = new int[26];
        for(int i =0; i<s.length();++i){
            arr[s.charAt(i)-'A']++;
        }
        ans = 0;
        insert(arr);
        return ans;
    }

    public static void main(String[] args) {
        LetterTilePossibilities lp = new LetterTilePossibilities();
        System.out.println(lp.numTilePossibilities("AAABBC"));
    }
}
