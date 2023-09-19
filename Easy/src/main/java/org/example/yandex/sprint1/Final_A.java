package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Final_A {
    /**
     * Slow - refactoring required.
     * @param arr
     * @return
     */
    public static String zero(List<Integer> arr) {

        int dist = Integer.MAX_VALUE;
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == 0) {
                dist = 0;
                firstPassArray.add(0);
            } else if (dist == -1){
                firstPassArray.add(dist);
            } else {
                firstPassArray.add(++dist);
            }
        }
        for(int i = arr.size() - 1; i >= 0; i--) {
            if(firstPassArray.get(i) == 0) {
                dist = 0;

            } else if (Character.digit(sb.charAt(i), Integer.MAX_VALUE) < dist) {
                ++dist;
            } else {
                sb.setCharAt(i, Character.(dist));
            }
        }
        return null;
        /*        TreeMap<Integer, Integer> zerosIdx = new TreeMap<>();
        StringBuilder distances = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                zerosIdx.put(i, 0);
            }
        }
        int minDist;
        Integer lower;
        Integer higher;
        for (int i = 0; i < arr.size(); i++) {
            if (zerosIdx.containsKey(i)) {
                distances.append(0).append(" ");
            } else {
                lower = zerosIdx.lowerKey(i);
                higher = zerosIdx.higherKey(i);
                if (higher == null) {
                    minDist = i - lower;
                } else if (lower == null) {
                    minDist = higher - i;
                } else {
                    minDist = (i - lower) > (higher - i) ? (higher - i) : (i - lower);
                }
                distances.append(minDist).append(" ");
            }
        }
        return distances.toString();*/
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            String result = zero(arr);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result);
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readList(BufferedReader reader) throws IOException {

        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem)).toArray();
    }
}