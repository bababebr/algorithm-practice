package org.example.yandex.sprint3;

import java.util.Arrays;

public class SimpleQuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        int border = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < border) i++;
            while (arr[j] > border) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }


    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 10, 5, 32, 16};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
