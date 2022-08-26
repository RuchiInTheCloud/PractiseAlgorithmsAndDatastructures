package leetcode;

import java.util.HashMap;

/*
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than lower[n / 2] times. You may assume that the majority element always exists in the array.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * > Math.floor(n/2)
 */
public class _3_MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numFrequency = new HashMap<>();
        for (int num: nums) {
            if (!numFrequency.containsKey(num)) {
                numFrequency.put(num, 0);
            }
            numFrequency.put(num, numFrequency.get(num) + 1);
        }

        int halfOfArrayLength = (int) Math.floor((double) (nums.length / 2));
        for (int num: numFrequency.keySet()) {
            if (numFrequency.get(num) > halfOfArrayLength) {
                return num;
            }
        }
        return 0;
    }
}
