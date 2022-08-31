package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _22_RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
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

    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
