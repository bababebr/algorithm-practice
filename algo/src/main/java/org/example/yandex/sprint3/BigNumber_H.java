package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BigNumber_H {

    public static String bigNumber(Integer[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : array) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            Integer[] arr = readArray(reader);
            System.out.println(bigNumber(arr));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Integer[] readArray(BufferedReader reader) throws IOException {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) > o2.charAt(0)) return -1;
                if (o1.charAt(0) < o2.charAt(0)) return 1;
                int o1first = Integer.parseInt(o1 + o2);
                int o2first = Integer.parseInt(o2 + o1);
                return o2first - o1first;
                //return o2.compareTo(o1);
            }
        };
        return Arrays.stream(reader.readLine().split(" ")).sorted(comparator).map(e -> Integer.parseInt(e)).toArray(Integer[]::new);
    }
}