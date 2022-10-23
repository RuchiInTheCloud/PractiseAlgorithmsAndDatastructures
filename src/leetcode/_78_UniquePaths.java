package leetcode;

import java.util.Arrays;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot
tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at
any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3

Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:
1 <= m, n <= 100
 */
public class _78_UniquePaths {
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(row, -2);
            }
            return countPaths(m, n, 0, 0, memo);
        }

        private int countPaths(int m, int n, int i, int j, int[][] memo) {
            if (i == m - 1 && j == n - 1) {
                return 1;
            } else if (i < 0 || i >= m || j < 0 || j >= n) {
                return -1;
            } else if (memo[i][j] != -2) {
                return memo[i][j];
            } else {
                int way1 = countPaths(m, n, i + 1, j, memo);
                int way2 = countPaths(m, n, i, j + 1, memo);
                memo[i][j] = ((way1 == -1) ? 0 : way1) + ((way2 == -1) ? 0 : way2);
                return memo[i][j];
            }
        }
    }
}
