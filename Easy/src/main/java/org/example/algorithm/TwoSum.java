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
        HashSet<Integer> resultsSet = new HashSet<>(arr.stream().map(i -> targetSum - i).collect(Collectors.toSet()));
        HashSet<Integer> array = new HashSet<>(arr);
        for(Integer i : array) {
            if(resultsSet.contains(targetSum - i)){
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