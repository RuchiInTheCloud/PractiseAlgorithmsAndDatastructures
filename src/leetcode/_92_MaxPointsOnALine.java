package leetcode;

import java.util.HashMap;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of
points that lie on the same straight line.

Example 1:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Example 2:
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

Constraints:
1 <= points.length <= 300
points[i].length == 2
-10^4 <= xi, yi <= 10^4
All the points are unique.
 */
public class _92_MaxPointsOnALine {
    class Solution {
        final double epsilon = 0.00001;

        public int maxPoints(int[][] points) {
            HashMap<Double, Integer> slopes = new HashMap<>();
            double slope = 0;
            int maxPointsOnSameLine = points.length >= 1 ? 1 : 0;
            for (int i = 0; i < points.length; i++) {
                slopes.clear();
                for (int j = 0; j < points.length; j++) {
                    if (i == j)
                        continue;
                    if (Math.abs(points[i][0] - points[j][0]) <= epsilon) {
                        slope = epsilon;
                    } else {
                        slope = (double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                    }
                    slopes.put(slope, slopes.getOrDefault(slope, 1) + 1);

                    if (maxPointsOnSameLine < slopes.get(slope)) {
                        maxPointsOnSameLine = slopes.get(slope);
                    }
                }
            }
            return maxPointsOnSameLine;
        }
    }
}
