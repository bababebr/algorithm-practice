package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FinalQuickSort {

    public static Participant[] partition(Participant[] array, int left, int right, int pivot) {
        System.out.println();
        while (left <= right) {
            System.out.println(left + " " + right);
            while (array[left].compareTo(array[pivot]) == -1) {
                left++;
            }
            while (array[right].compareTo(array[pivot]) == 1) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void quicksort(Participant[] array, int left, int right) {
        int pivot = (left + right) / 2;
        if (left >= right) {
            return;
        }
        if(right - left <= 2) {
            return;
        }
        array = partition(array, left, right, pivot);
        quicksort(array, 0, pivot);
        quicksort(array, pivot, array.length - 1);
    }

    public static void swap(Participant[] list, int left, int right) {
        Participant temp = list[left];
        list[left] = list[right];
        list[right] = temp;
        System.out.println(list[right] + " swapped with " + list[left]);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            Participant[] list = new Participant[n];
            for (int i = 0; i < n; i++) {
                readArray(reader, list, i);
            }
           quicksort(list, 0, list.length - 1);
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
            else if (penalty < participant.penalty) {
                return 1;
            } else {
                return 0;
            }
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
