package leetcode;

/*
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those
integers.

Return the maximum product you can get.

Example 1:
Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:
Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

Constraints:
2 <= n <= 58
 */
public class _88_IntegerBreak {
    class Solution {
        public int integerBreak(int n) {
            int[] memo = new int[n + 1];
            memo[0] = 1;
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                if (i != n) {
                    memo[i] = i;
                }
                for (int j = 1; j < i; j++) {
                    if (memo[j] * memo[i - j] > memo[i]) {
                        memo[i] = memo[j] * memo[i - j];
                    }
                }
            }
            return memo[n];
        }
    }
}
