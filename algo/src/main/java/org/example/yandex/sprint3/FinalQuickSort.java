package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FinalQuickSort {

    public static void quickSort(Participant[] arr, int low, int high) {
        if (arr.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        Participant border = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i].compareTo(border) == 1) i++;
            while (arr[j].compareTo(border) == -1) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }

    public static void swap(Participant[] list, int left, int right) {
        Participant temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            Participant[] list = new Participant[n];
            for (int i = 0; i < n; i++) {
                readArray(reader, list, i);
            }
            quickSort(list, 0, list.length - 1);
            StringBuilder sb = new StringBuilder();
            for (Participant p : list) {
                sb.append(p.name).append(System.lineSeparator());
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static Participant[] readArray(BufferedReader reader, Participant[] list, int i) throws IOException {
        String[] line = reader.readLine().split(" ");
        list[i] = new Participant(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        return list;
    }

    static class Participant implements Comparable {
        private final String name;
        private final int completedTasks;
        private final int penalty;

        public Participant(String name, int completedTasks, int penalty) {
            this.name = name;
            this.completedTasks = completedTasks;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Object o) {
            Participant participant = (Participant) o;
            if (completedTasks > participant.completedTasks) return 1;
            if (completedTasks < participant.completedTasks) return -1;
            if (penalty > participant.penalty) return -1;
            if (penalty < participant.penalty) return 1;
            if (participant.name.compareTo(name) > 0) return 1;
            if (participant.name.compareTo(name) < 0) return -1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Participant that = (Participant) o;
            return completedTasks == that.completedTasks && penalty == that.penalty && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, completedTasks, penalty);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
