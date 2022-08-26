package leetcode;

/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]

Constraints:
1 <= n <= 20
*/

public class _10_SpiralMatrix {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int count = 0;
            for (int i = 0; i <= n/2; i++) {
                int last = n - 1 - i;
                for (int j = i; j <= last; j++) {
                    matrix[i][j] = (++count);
                }
                for (int j = i + 1; j <= last; j++) {
                    matrix[j][last] = (++count);
                }
                for (int j = i + 1; j <= last; j++) {
                    matrix[last][n - 1 - j] = (++count);
                }
                for (int j = i + 1; j < last; j++) {
                    matrix[n - 1 - j][i] = (++count);
                }
            }
            return matrix;
        }
    }
}
