package org.example.yandex.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint4Final_A {

    public static void search(HashMap<String, HashMap<Integer, Integer>> index, List<Set<String>> searches, int docs) {
        for (Set<String> set : searches) {
            int[] result = new int[docs];
            for (String s : set) {
                if (index.containsKey(s)) {
                    for (Map.Entry<Integer, Integer> entry : index.get(s).entrySet()) {
                        result[entry.getKey()] += entry.getValue();
                    }
                }
            }
            sortIndices(result);
        }
    }

    public static void sortIndices(int[] input) {
        Integer[] indices = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (o1, o2) -> input[o2] - input[o1]);
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i : indices) {
            if (counter == 5) break;
            if (input[i] != 0) {
                sb.append(i + 1).append(" ");
            }
            counter++;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int docs = readInt(reader);
            HashMap<String, HashMap<Integer, Integer>> indexMap = new HashMap<>();

            for (int i = 0; i < docs; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                while (tokenizer.hasMoreTokens()) {
                    String s = tokenizer.nextToken();
                    //Берем каждый документ
                    //Берем каждое слово в документе
                    //Если данное слово уже есть в словаре берем мапу и проверяем, если ли данное слово в текущем документе
                    if (indexMap.containsKey(s)) {
                        //Если это слово уже есть в докумете, то увеличиваем на 1
                        if (indexMap.get(s).containsKey(i)) {
                            int add = indexMap.get(s).get(i) + 1;
                            indexMap.get(s).put(i, add);
                        }
                        //Если в этом документе такого слова нет, то создаем
                        else {
                            HashMap<Integer, Integer> tempMap = new HashMap<>();
                            tempMap.put(i, 1);
                            indexMap.get(s).put(i, 1);
                        }
                    }
                    //Если такого слова вообще нет, то добавляем
                    else {
                        HashMap<Integer, Integer> temp = new HashMap<>();
                        temp.put(i, 1);
                        indexMap.put(s, temp);
                    }
                }
            }
            int searches = readInt(reader);
            ArrayList<Set<String>> list = new ArrayList<>();
            for (int i = 0; i < searches; i++) {
                Set<String> searchWords = new HashSet<>();
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                while (tokenizer.hasMoreTokens()) {
                    searchWords.add(tokenizer.nextToken());
                }
                //searchWords.addAll(List.of(reader.readLine().split(" ")));
                list.add(searchWords);
            }
            search(indexMap, list, docs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Integer[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    }
}
