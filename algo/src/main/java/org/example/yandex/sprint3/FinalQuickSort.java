package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FinalQuickSort {

    public static List<Participant>[] partition(List<Participant> array, Participant pivot) {
        List<Participant> left = new ArrayList<>();
        List<Participant> center = new ArrayList<>();
        List<Participant> right = new ArrayList<>();
        for (Participant x : array) {
            if (x.compareTo(pivot) == 1) {
                left.add(x);
            } else if (x.compareTo(pivot) == 0) {
                center.add(x);
            } else {
                right.add(x);
            }
        }
        return new List[]{left, center, right};
    }

    public static List<Participant> quicksort(List<Participant> array) {
        if (array.size() < 2) {
            return array; // массивы с 0 или 1 элементами фактически отсортированы
        } else {
            Random random = new Random();
            Participant pivot = array.get(random.nextInt(array.size()));
            List<Participant>[] parts = partition(array, pivot);
            return concatenate(quicksort(parts[0]), parts[1], quicksort(parts[2]));
        }
    }

    public static List<Participant> concatenate(List<Participant> a, List<Participant> b, List<Participant> c) {
        List<Participant> result = new ArrayList<>(a.size() + b.size() + c.size());
        result.addAll(a);
        result.addAll(b);
        result.addAll(c);
        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            ArrayList<Participant> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                readArray(reader, list, i);
            }
            List<Participant> result = quicksort(list);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static ArrayList readArray(BufferedReader reader, ArrayList<Participant> list, int i) throws IOException {
        String[] line = reader.readLine().split(" ");
        list.add(new Participant(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2])));
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
