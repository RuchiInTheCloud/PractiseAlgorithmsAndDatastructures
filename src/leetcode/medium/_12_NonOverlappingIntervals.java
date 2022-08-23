package leetcode.medium;

import java.util.Arrays;

/*
Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Constraints:
1 <= intervals.length <= 10^5
intervals[i].length == 2
-5 * 10^4 <= starti < endi <= 5 * 10^4
 */
public class _12_NonOverlappingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
            int countNonOverlapping = 0;
            int end = Integer.MIN_VALUE;
            for (int[] interval : intervals) {
                if (interval[0] >= end) {
                    end = interval[1];
                    countNonOverlapping++;
                }
            }
            return intervals.length - countNonOverlapping;
        }
    }
}
