package leetcode.medium;

import java.util.HashMap;

public class _14_SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ways = 0;
            int runningSum = 0;
            HashMap<Integer, Integer> runningSums = new HashMap<>();
            runningSums.put(0, 1);

            for (int i = 0; i < nums.length; i++) {
                runningSum += nums[i];

                int previousSum = runningSum - k;
                ways += runningSums.getOrDefault(previousSum, 0);

                runningSums.put(runningSum, runningSums.getOrDefault(runningSum, 0) + 1);
            }
            return ways;
        }
    }
}
