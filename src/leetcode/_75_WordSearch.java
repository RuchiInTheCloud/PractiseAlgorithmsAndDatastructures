package leetcode;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

Follow up: Could you use search pruning to make your solution faster with a larger board?
*/
public class _75_WordSearch {
    class Solution {
        final int[][] delta = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        public boolean exist(char[][] board, String word) {
            char temp;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (exist(board, word, 0, i, j)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean exist(char[][] board, String word, int index, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
                return false;
            }

            if (index == word.length() - 1) {
                return true;
            }

            char temp = board[i][j];
            board[i][j] = '0';
            for (int k = 0; k < delta.length; k++) {
                if (exist(board, word, index + 1, i + delta[k][0], j + delta[k][1])) {
                    return true;
                }
            }
            board[i][j] = temp;
            return false;
        }
    }
}
