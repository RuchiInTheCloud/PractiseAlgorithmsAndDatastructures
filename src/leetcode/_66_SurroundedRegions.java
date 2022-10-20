package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.

Example 2:
Input: board = [["X"]]
Output: [["X"]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */
public class _66_SurroundedRegions {
    class Solution {
        public void solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if ((i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) && board[i][j] == 'O') {
                        findConnectedRegion(board, i, j);
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == 'U') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void findConnectedRegion(char[][] board, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'X' || board[i][j] == 'U') {
                return;
            }
            board[i][j] = 'U';
            findConnectedRegion(board, i - 1, j);
            findConnectedRegion(board, i, j - 1);
            findConnectedRegion(board, i, j + 1);
            findConnectedRegion(board, i + 1, j);
        }
    }
}
