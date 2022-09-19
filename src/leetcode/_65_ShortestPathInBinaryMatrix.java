package leetcode;

import java.util.LinkedList;

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1

Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
 */
public class _65_ShortestPathInBinaryMatrix {
    class Solution {
        class Coordinate {
            int x;
            int y;
            int distance;

            Coordinate(int x, int y, int distance) {
                this.x = x;
                this.y = y;
                this.distance = distance;
            }
        }

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            int[][] delta = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            LinkedList<Coordinate> queue = new LinkedList<>();
            addNeighbour(0, 0, grid, queue, 0);

            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.remove();

                if ((coordinate.x == n - 1) && (coordinate.y == n - 1)) {
                    return coordinate.distance;
                }

                for (int i = 0; i < 8; i++) {
                    addNeighbour(coordinate.x + delta[i][0], coordinate.y + delta[i][1], grid, queue,
                            coordinate.distance);
                }
            }

            return -1;
        }

        private void addNeighbour(int x, int y, int[][] grid, LinkedList<Coordinate> queue, int parentDistance) {
            if (isCoordinateValid(x, y, grid)) {
                queue.add(new Coordinate(x, y, parentDistance + 1));
                grid[x][y] = 1;
            }
        }

        private boolean isCoordinateValid(int x, int y, int[][] grid) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] == 1) {
                return false;
            }
            return true;
        }
    }
}
