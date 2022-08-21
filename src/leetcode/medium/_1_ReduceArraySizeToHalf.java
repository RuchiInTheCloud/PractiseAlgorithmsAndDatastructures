package leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
Return the minimum size of the set so that at least half of the integers of the array are removed.
Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
*/

public class _1_ReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        if (arr == null) {
            return 0;
        }
        HashMap<Integer, Integer> numberFrequency = new HashMap<>();
        for (int x: arr) {
            if (!numberFrequency.containsKey(x)) {
                numberFrequency.put(x, 0);
            }
            numberFrequency.put(x, numberFrequency.get(x) + 1);
        }

        int distinctNumberCount = numberFrequency.keySet().size();
        Integer[] numberOccurenceCounts = new Integer[distinctNumberCount];
        int i = 0;
        for (int x: numberFrequency.keySet()) {
            numberOccurenceCounts[i] = numberFrequency.get(x);
            i += 1;
        }

        Arrays.sort(numberOccurenceCounts, Collections.reverseOrder());

        int setSize = 0;
        int currentSize = arr.length;
        for (int x: numberOccurenceCounts) {
            currentSize -= x;
            setSize += 1;
            if (currentSize <= arr.length / 2) {
                break;
            }
        }
        return setSize;
    }
}
