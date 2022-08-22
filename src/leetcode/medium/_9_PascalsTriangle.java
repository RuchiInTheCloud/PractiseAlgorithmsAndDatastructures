package leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class _9_PascalsTriangle {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex == 0) {
                return List.of(1);
            } else if (rowIndex == 1) {
                return List.of(1, 1);
            }

            Integer[] currentRow = new Integer[rowIndex + 1];
            Arrays.fill(currentRow, 1);

            for (int i = 2; i <= rowIndex; i++) {
                for (int j = i - 1; j > 0; j--) {
                    currentRow[j] = currentRow[j] + currentRow[j - 1];
                }
            }
            return Arrays.asList(currentRow);
        }
    }
}
