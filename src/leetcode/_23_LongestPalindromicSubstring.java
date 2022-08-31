package leetcode;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class _23_LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1)
                return "";

            int start, end;
            start = end = 0;
            for (int i = 0; i < s.length(); i++) {
                int resultOdd = findPalindromeSize(s, i, i);
                int resultEven = findPalindromeSize(s, i - 1, i);

                int len = Math.max(resultOdd, resultEven);
                if (len > end - start) {
                    start = i - len / 2;
                    end = i + (len + 1) / 2;
                }
            }
            return s.substring(start, end);
        }

        public int findPalindromeSize(String s, int leftIndex, int rightIndex) {
            while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
                leftIndex--;
                rightIndex++;
            }
            return rightIndex - leftIndex - 1;
        }
    }
}
