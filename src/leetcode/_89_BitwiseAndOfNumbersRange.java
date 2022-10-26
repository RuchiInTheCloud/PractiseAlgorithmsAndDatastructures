package leetcode;

/*
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

Example 1:
Input: left = 5, right = 7
Output: 4

Example 2:
Input: left = 0, right = 0
Output: 0

Example 3:
Input: left = 1, right = 2147483647
Output: 0

Constraints:
0 <= left <= right <= 2^31 - 1
 */
public class _89_BitwiseAndOfNumbersRange {
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int mask = (1 << i);
                if ((left & mask) != (right & mask)) {
                    return res;
                } else {
                    res |= (mask & left);
                }
            }
            return res;
        }
    }
}
