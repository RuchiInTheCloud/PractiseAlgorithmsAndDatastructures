package leetcode;

import java.util.Arrays;

/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common
subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none)
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:
1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters
 */
public class _84_LongestCommenSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[] lengths = new int[text2.length()];
            int[] prevLengths = new int[text2.length()];

            int[] temp;
            for (int i = text1.length() - 1; i >= 0; i--) {
                for (int j = text2.length() - 1; j >= 0; j--) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        lengths[j] = 1 + (j + 1 < text2.length() ? prevLengths[j + 1] : 0);
                    } else {
                        lengths[j] = Math.max((j + 1 < text2.length() ? lengths[j + 1] : 0), prevLengths[j]);
                    }
                }
                temp = lengths;
                lengths = prevLengths;
                prevLengths = temp;
                Arrays.fill(lengths, 0);
            }
            return prevLengths[0];
        }
    }
}
