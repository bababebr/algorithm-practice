package org.example.yandex.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class D_circles {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            HashSet<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            int n = readInt(reader);
            for(int i = 0; i < n; i++) {
                String s = reader.readLine();
                if(set.add(s)) sb.append(s).append(System.lineSeparator());
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
