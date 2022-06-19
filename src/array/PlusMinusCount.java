package array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinusCount {
    public static void plusMinus(List<Integer> arr) {
        int zeroCount = 0, positiveCount = 0, negativeCount = 0;
        for(int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 0) {
                negativeCount ++;
            } else if (arr.get(i) > 0) {
                positiveCount ++;
            } else {
                zeroCount ++;
            }
        }
        System.out.printf("%.6f \n",(float) positiveCount/arr.size());
        System.out.printf("%.6f \n",(float) negativeCount/arr.size());
        System.out.printf("%.6f \n",(float) zeroCount/arr.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C://Development//AlgorithmsAndDatastructures//src//array//problem.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinusCount.plusMinus(arr);

        bufferedReader.close();
    }
}
