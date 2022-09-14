package leetcode;

import java.util.ArrayList;

/*
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Example 2:
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []

Constraints:
0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 109
endi < starti+1
0 <= startj < endj <= 109
endj < startj+1
 */
public class _57_IntervalListIntersections {
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            ArrayList<int[]> intersectionList = new ArrayList<>();

            int[] intersection;
            int i = 0, j = 0;
            while (i < firstList.length && j < secondList.length) {
                if ((secondList[j][0] <= firstList[i][0] && firstList[i][0] <= secondList[j][1]) || (
                        secondList[j][0] <= firstList[i][1] && firstList[i][1] <= secondList[j][1]) || (
                        firstList[i][0] <= secondList[j][0] && secondList[j][0] <= firstList[i][1]) || (
                        firstList[i][0] <= secondList[j][1] && secondList[j][1] <= firstList[i][1])) {
                    intersection = new int[2];
                    intersection[0] = Math.max(firstList[i][0], secondList[j][0]);
                    intersection[1] = Math.min(firstList[i][1], secondList[j][1]);
                    intersectionList.add(intersection);
                }

                if (firstList[i][1] < secondList[j][1]) {
                    i++;
                } else if (firstList[i][1] > secondList[j][1]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
            return intersectionList.toArray(new int[0][0]);
        }
    }
}
