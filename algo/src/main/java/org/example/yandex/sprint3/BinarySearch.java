package org.example.yandex.sprint3;

public class BinarySearch {

    public static int binarySearch(int[] array, int n, int left, int right) {
        if (right <= left) { // промежуток пуст
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == n) {
            return n;
        } else if (n > array[mid]) {
            return binarySearch(array, n, mid + 1, right);
        } else {
            return binarySearch(array, n, left, mid);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(array, 4, 0, array.length));
    }

}
