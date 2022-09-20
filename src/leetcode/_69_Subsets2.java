package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _69_Subsets2 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> allSubsets = new LinkedList<>();
            List<Integer> emptySet = new LinkedList<>();
            generatePowerSet(0, emptySet, allSubsets, nums);
            return allSubsets;
        }

        public void generatePowerSet(int index, List<Integer> subset, List<List<Integer>> allSubsets, int[] nums) {
            allSubsets.add(new LinkedList<>(subset));

            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i] == nums[i - 1])
                    continue;
                subset.add(nums[i]);
                generatePowerSet(i + 1, subset, allSubsets, nums);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
