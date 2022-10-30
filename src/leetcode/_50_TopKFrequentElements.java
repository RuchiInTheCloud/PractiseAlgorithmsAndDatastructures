package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any
order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class _50_TopKFrequentElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> numFrequency = new HashMap<>();
            int maxFrequency = Integer.MIN_VALUE;
            for (int num : nums) {
                int frequency = numFrequency.getOrDefault(num, 0);
                numFrequency.put(num, frequency + 1);
                if (frequency + 1 > maxFrequency) {
                    maxFrequency = frequency + 1;
                }
            }
            List<Integer>[] counts = new ArrayList[maxFrequency + 1];
            for (int num : numFrequency.keySet()) {
                int frequency = numFrequency.get(num);
                if (counts[frequency] == null) {
                    counts[frequency] = new ArrayList<Integer>();
                }
                counts[frequency].add(num);
            }
            int[] result = new int[k];
            for (int i = counts.length - 1; i >= 0; i--) {
                if (counts[i] != null && k > 0) {
                    for (int num : counts[i]) {
                        result[k - 1] = num;
                        k -= 1;
                        if (k == 0) {
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }
}
