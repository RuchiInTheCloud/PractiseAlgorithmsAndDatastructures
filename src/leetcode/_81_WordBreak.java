package leetcode;

import java.util.List;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence
of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */
public class _81_WordBreak {
    class Solution {
        // if index == s.length --> return true;
        // for every word in dict
        //  check if the word is located at "start" of string
        //      if yes, search for the "remainder" of the string
        // return false
        // O(n * m^n)
        //
        // _ _ _ _ _ _ _ _
        // DP (s.length) = true
        // DP (i) = WordMatch && DP (i + matchedWord.len)
        // DP (0) = WordMatch && DP (0 + matchedWord.len)
        // O(n * m * n)
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] memo = new boolean[s.length() + 1];
            memo[s.length()] = true;
            int index = s.length() - 1;

            while (index >= 0) {
                for (String word: wordDict) {
                    if (index + word.length() <= s.length() && exists(s, word, index)) {
                        memo[index] = memo[index + word.length()];
                        if (memo[index]) {
                            break;
                        }
                    }
                }
                index -= 1;
            }
            return memo[0];
        }
        private boolean exists(String s, String w, int index) {
            for (int i = 0; i < w.length(); i++) {
                if (s.charAt(index + i) != w.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
