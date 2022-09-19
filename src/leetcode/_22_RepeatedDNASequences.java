package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

Constraints:
1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class _22_RepeatedDNASequences {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            HashMap<String, Integer> repeatingSequenceCounts = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                repeatingSequenceCounts.put(s.substring(i, i + 10),
                        repeatingSequenceCounts.getOrDefault(s.substring(i, i + 10), 0) + 1);
            }

            List<String> repeatingSequences = new ArrayList<>();
            for (String sequence : repeatingSequenceCounts.keySet()) {
                if (repeatingSequenceCounts.get(sequence) > 1) {
                    repeatingSequences.add(sequence);
                }
            }

            return repeatingSequences;
        }
    }
}
