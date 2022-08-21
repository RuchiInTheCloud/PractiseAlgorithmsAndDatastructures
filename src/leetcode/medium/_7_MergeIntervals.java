package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and
return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/
public class _7_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int index = 0;
        int[] mergedInterval = null;

        while (index < intervals.length) {
            if (mergedInterval == null) {
                mergedInterval = new int[2];
                mergedIntervals.add(mergedInterval);

                mergedInterval[0] = intervals[index][0];
                mergedInterval[1] = intervals[index][1];
                index +=1;
            } else if (intervals[index][0] <= mergedInterval[1]) {
                mergedInterval[1] = Math.max(mergedInterval[1], intervals[index][1]);
                index +=1;
            } else if (intervals[index][0] > mergedInterval[1]) {
                mergedInterval = null;
            }
        }

        return mergedIntervals.stream().toArray(int[][]::new);
    }
}
