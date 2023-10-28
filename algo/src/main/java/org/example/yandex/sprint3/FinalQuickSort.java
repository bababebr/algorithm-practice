package org.example.yandex.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FinalQuickSort {
    /*
-- ПРИНЦИП РАБОТЫ --
    Посылка - 94725154
    Метод принимает массив и указатели на левую и правую границу подмассива, далее выбираем pivot -  у меня это средний
    элемент.
    Начинаем идти по массиву пока не найдем два эл-та с каждой стороны от pivot`a стоящие не на своих местах,
    когда нашли - меняем их местами.
    После этого рекурсивно вызываем сортировку.

    Для удобства работы написал класс Participant в котором реализовал compareTo согласно условию задачи

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

    На каждой итерации алгоритм гарантирует, что слева находятся эл-ты меньше pivot`a, а справа - больше.
    Так же, размер неотсортированной части массива будет сокращаться от итерации к итерации.
    В конечном итоге длина неотсортированной части массива будет равно нулю.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --

Все зависиот от выбора опорного эл-та, если была бы возможность на каждом вызове сортировки выбирать опорным эл-том медиану,
то сложность -> O(NlogN) - это лучший и средний случай. O(LogN) получается в результате рекурсивного деления массива
на два половины, O(N) - появляется в моменте прохода по подмассиву, когда мы ищем стоящие не на своих местах эл-ты, для
каждый итерации размер подмассива уменьшается вдвое, а суммарное кол-во подмассивов увеличивается, отсюда и O(N)

Тогда, в сумме получается O(NlogN).

В худшем случае, массив поделится на пустой подмассив и остальной (N-1), тогда сложность = O(n^2)
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --

    Сортировка in-place, значит на каждом уровне рекурсии не выделяется дополнительной памяти и пространственная сложность
    будет равно глубине рекурсии O(m);

*/
    public static void quickSort(Participant[] arr, int left, int right) {
        if (arr.length == 0 || left >= right) return;
        int pivotIdx = left + (right - left) / 2;
        Participant pivot = arr[pivotIdx];
        int i = left, j = right;

        while (i <= j) {
            while (arr[i].compareTo(pivot) > 0) i++;
            while (arr[j].compareTo(pivot) < 0) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        quickSort(arr, left, j);
        if (right > i) quickSort(arr, j + 1, right);
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
/*            if (completedTasks > participant.completedTasks) return 1;
            if (completedTasks < participant.completedTasks) return -1;*/
            if (completedTasks != participant.completedTasks) return completedTasks - participant.completedTasks;
            if (penalty != participant.penalty) return participant.penalty - penalty;
            if (participant.name.compareTo(name) > 0) return 1;
            if (participant.name.compareTo(name) < 0) return -1;
            return 0;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
