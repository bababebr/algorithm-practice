package org.example.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Дана матрица. Нужно написать функцию, которая для элемента возвращает всех его соседей. Соседним считается элемент,
 * находящийся от текущего на одну ячейку влево, вправо, вверх или вниз. Диагональные элементы соседними не считаются.
 * <p>
 * Например, в матрице A соседними элементами для (0, 0) будут 2 и 0. А для (2, 1) –— 1, 2, 7, 7.
 */

/**
 * Формат ввода
 * В первой строке задано n — количество строк матрицы. Во второй — количество столбцов m. Числа m и n не превосходят 1000.
 * В следующих n строках задана матрица. Элементы матрицы — целые числа, по модулю не превосходящие 1000.
 * В последних двух строках записаны координаты элемента, соседей которого нужно найти. Индексация начинается с нуля.
 * <p>
 * Формат вывода
 * Напечатайте нужные числа в возрастающем порядке через пробел.
 */
public class C {

    private static List<Integer> getNeighbours(List<List<Integer>> matrix, int row, int col) {
        ArrayList<Integer> neighbours = new ArrayList<>();
        int colCount = matrix.get(0).size();
        int rowCount = matrix.size();
        if (col > colCount - 1 || row > rowCount - 1) {
            throw new IllegalStateException("Element not found");
        }

        try {
            neighbours.add(matrix.get(row - 1).get(col));
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            neighbours.add(matrix.get(row).get(col + 1));

        } catch (IndexOutOfBoundsException e) {

        }
        try {
            neighbours.add(matrix.get(row + 1).get(col));
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            neighbours.add(matrix.get(row).get(col - 1));
        } catch (IndexOutOfBoundsException e) {

        }
        Collections.sort(neighbours);
        return neighbours;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rowsCount = readInt(reader);
            int colsCount = readInt(reader);
            List<List<Integer>> matrix = readMatrix(reader, rowsCount);
            int rowId = readInt(reader);
            int colId = readInt(reader);
            List<Integer> neighbours = getNeighbours(matrix, rowId, colId);
            for (int element : neighbours) {
                System.out.print(element + " ");
            }
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

    private static List<List<Integer>> readMatrix(BufferedReader reader, int rowsCount) throws IOException {
        List<List<Integer>> matrix = new ArrayList<>(rowsCount);
        for (int i = 0; i < rowsCount; i++) {
            matrix.add(readList(reader));
        }
        return matrix;
    }
}