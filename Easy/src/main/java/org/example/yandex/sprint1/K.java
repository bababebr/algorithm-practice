package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K {

    private static List<Integer> getSum(List<Integer> numberList, int k) {
        StringBuilder sb = new StringBuilder();

        if (k == -1) {
            return numberList;
        }

        int kLength = String.valueOf(k).length();
        if (kLength > numberList.size()) {
            for (Integer i : numberList) {
                sb.append(i);
            }
        } else {
            for (int i = (numberList.size() - kLength); i < numberList.size(); i++) {
                sb.append(numberList.get(i));
            }
        }
        int subInt = Integer.parseInt(sb.toString()) + k;
        int subIntLength = String.valueOf(subInt).length();
        if (numberList.size() < subIntLength) {
            numberList = new ArrayList<>();
        } else {
            for (int i = 0; i < subIntLength; i++) {
                numberList.remove(numberList.size() - 1);
            }
        }
        for (int i = 0; i < subIntLength; i++) {
            numberList.add(Integer.parseInt(String.valueOf(String.valueOf(subInt).charAt(i))));
        }
        return numberList;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberLength = readInt(reader);
            List<Integer> numberList = readList(reader);
            int k = readInt(reader);
            List<Integer> sum = getSum(numberList, k);
            for (int elem : sum) {
                writer.write(elem + " ");
            }
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line.isEmpty()) {
            return -1;
        }
        return Integer.parseInt(line);
    }
}