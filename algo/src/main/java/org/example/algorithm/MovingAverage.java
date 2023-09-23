package org.example.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovingAverage {

    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        ArrayList<Double> result = new ArrayList<>();
        if (windowSize >= n) {
            result.add(arr.stream().reduce(0, Integer::sum).doubleValue() / windowSize);
            return result;
        }
        int left = 0;
        int right = windowSize;
        double sum = arr.subList(left, right).stream().reduce(0, Integer::sum).doubleValue();
        result.add(sum / windowSize);
        while (right < n) {
            sum -= arr.get(left);
            sum += arr.get(right);
            result.add(sum / windowSize);
            left++;
            right++;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int windowSize = readInt(reader);
            List<Double> result = movingAverage(n, arr, windowSize);
            for (double elem : result) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }
}