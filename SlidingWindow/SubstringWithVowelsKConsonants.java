/*
LC : 3306. Count of Substrings Containing Every Vowel and K Consonants II
 */
package DSA500.SlidingWindow;

public class SubstringWithVowelsKConsonants {
    public static boolean isVowel(char ch){
        return "aeiou".indexOf(ch) >= 0;
    }
    public static long countOfSubstrings(String s, int k) {
        int[] vowFreq = new int[26];
        int n = s.length();
        long ans = 0;
        int[] suff = new int[n + 2];
        int j = 0, v = 0, c = 0;
        for (int i = n - 1; i >= 0; --i)
            suff[i] = isVowel(s.charAt(i)) ? 1 + suff[i + 1] : 0; // count vowels at index i which appear in a row after the i index
        int i = 0;
        while (j < n) {
            while (j < n && c < k) { // loop first makes sure count of consonants matches k
                char ch = s.charAt(j);
                if (isVowel(ch)) {
                    vowFreq[ch - 'a']++;
                    v += vowFreq[ch - 'a'] == 1 ? 1 : 0;
                } else {
                    c++;
                }
                j++;
            }
            if (c == k) {
                while (j < n && c == k && v < 5) { // once the count of consonants matches ,we try match count of vowels.
                    char ch = s.charAt(j);
                    if (isVowel(ch)) {
                        vowFreq[ch - 'a']++;
                        v += vowFreq[ch - 'a'] == 1 ? 1 : 0;
                    } else {
                        c++;
                    }
                    j++;
                }
                while (c == k && v == 5) { // once the  conditions reach, try to add to answer and shrink the window
                    ans += 1 + suff[j];
                    char ch = s.charAt(i);
                    if (isVowel(ch)) {
                        vowFreq[ch - 'a']--;
                        v -= vowFreq[ch - 'a'] == 0 ? 1 : 0;
                    } else {
                        c--;
                    }
                    i++;
                }
                while (c > k) { // in case while adding vowels, we added too many consonants, then try to shrink window to reduce consonant.
                    char ch = s.charAt(i);
                    if (isVowel(ch)) {
                        vowFreq[ch - 'a']--;
                        v -= vowFreq[ch - 'a'] == 0 ? 1 : 0;
                    } else {
                        c--;
                    }
                    i++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Count of substrings = "+ countOfSubstrings("ieaouqqieaouqq",1));
    }
}


