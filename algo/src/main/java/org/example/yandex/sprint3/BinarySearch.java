package org.example.yandex.sprint3;

public class BinarySearch {

    public static int binarySearch(int[] array, int n, int left, int right) {
        if (right <= left) { // промежуток пуст
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == n) {
            return mid;
        } else if (n > array[mid]) {
            return binarySearch(array, n, mid + 1, right);
        } else {
            return binarySearch(array, n, left, mid);
        }
    }

    public static void main(String[] args) {
        int[] arr5 = {1, 2, 3, 5, 6, 7, 9, 0};
        System.out.println(binarySearch(arr5, 0, 7, arr5.length));
    }

}
