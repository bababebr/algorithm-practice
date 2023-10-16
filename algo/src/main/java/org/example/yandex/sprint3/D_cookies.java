package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D_cookies {

    public static void cookie(Integer[] greed, Integer[] cookies) {
        int result = 0;
        int max = cookies.length >= greed.length ? greed.length : cookies.length;
        for(int i = 0; i < max; i++) {
            if(greed[i] <= cookies[i]) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            Integer[] greed = readArray(reader);
            int m = readInt(reader);
            Integer[] cookies = readArray(reader);
            cookie(greed, cookies);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Integer[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(e -> Integer.parseInt(e)).sorted().toArray(Integer[]::new);
    }

}
