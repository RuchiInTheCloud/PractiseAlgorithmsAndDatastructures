package leetcode;

public class _38_RotateImage {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                int last = n - 1 - i;
                for (int j = i; j < last; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[last][n - 1 - j];
                    matrix[last][n - 1 - j] = matrix[j][last];
                    matrix[j][last] = temp;
                }
            }
        }
    }
}
