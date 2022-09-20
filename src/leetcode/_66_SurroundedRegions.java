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
        class Coordinate {
            int x;
            int y;

            Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public void solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                        if (board[i][j] == 'O') {
                            bfs(board, i, j);
                        }
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == 'E') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void bfs(char[][] board, int i, int j) {
            int[][] delta = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            Queue<Coordinate> queue = new LinkedList<>();
            addNeighbour(queue, i, j, board);

            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.remove();
                for (int k = 0; k < delta.length; k++) {
                    addNeighbour(queue, coordinate.x + delta[k][0], coordinate.y + delta[k][1], board);
                }
            }
        }

        private void addNeighbour(Queue<Coordinate> queue, int x, int y, char[][] board) {
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                queue.add(new Coordinate(x, y));
                board[x][y] = 'E';
            }
        }
    }
}
