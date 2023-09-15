package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.io.IOException;


public class D {

    private static int getWeatherRandomness(List<Integer> temperatures) {
        int daysCount = 0;
        if (temperatures.size() == 1) return 1;

        if (temperatures.get(0) > temperatures.get(1)) {
            daysCount++;
        }

        for (int i = 1; i < temperatures.size() - 1; i++) {
            if (temperatures.get(i) > temperatures.get(i - 1) &&
                    temperatures.get(i) > temperatures.get(i + 1)) {
                daysCount++;
            }
        }

        if (temperatures.get(temperatures.size() - 1) > temperatures.get(temperatures.size() - 2)) {
            daysCount++;
        }
        return daysCount;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfDays = readInt(reader);
            List<Integer> temperatures = readList(reader);
            int chaosNumber = getWeatherRandomness(temperatures);
            System.out.println(chaosNumber);
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