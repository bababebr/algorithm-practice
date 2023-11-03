package org.example.yandex.sprint4;

import org.example.yandex.sprint1.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class J_4Sum {

    public static int sum4(Integer[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> result = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int target = sum - arr[i] - arr[j] - arr[k];
                    if (set.contains(target)) {
                        result.add(List.of(target, arr[i], arr[j], arr[k]));
                    }
                    set.add(arr[i]);
                }
            }
        }
        result.stream().collect(Collectors.toList());
        return result.size();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            int sum = readInt(reader);
            System.out.println(sum4(readArray(reader), sum));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Integer[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine()
                        .split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);
    }
}
