package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MinMaxSum {
    private static void minMaxSum (List<Integer> arr) {
        Integer max, min;
        max = min = arr.get(0);
        long sum = 0;
        for(Integer elem: arr) {
            sum += elem;
            if (elem > max) max = elem;
            if (elem < min) min = elem;
        }
        System.out.println((sum - max) + " "+ (sum - min));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Stream.of(reader.readLine().replaceAll("\\s+$","").split(" ")).map(Integer::parseInt).collect(toList());
        minMaxSum(arr);
    }
}
