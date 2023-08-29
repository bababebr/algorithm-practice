package org.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список 
    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        HashSet<Integer> array = new HashSet<>(arr);
        List<Integer> lookingForNumbers = array.stream().map(i -> targetSum - i).collect(Collectors.toList());
        HashSet<Integer> lookingForNumbersSet = new HashSet<>(lookingForNumbers);
        lookingForNumbersSet.retainAll(array);
        for (Integer i : arr) {
            lookingForNumbersSet.remove(i);
            if (lookingForNumbersSet.contains(targetSum - i)) {
                return List.of(i, targetSum - i);
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
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