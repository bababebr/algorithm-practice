package org.example.yandex.sprint3;

public class BrokenArray {

    public static int brokenSearch(int[] arr, int k) {
        int pivot = findPivot(arr, 0, arr.length - 1) + 1;
        if (pivot == -1) return binarySearch(arr, k, 0, arr.length - 1);
        if (arr[pivot] == k) return pivot;
        if (arr[0] <= k) {
            return binarySearch(arr, k, 0, pivot - 1);
        }
        return binarySearch(arr, k, pivot + 1, arr.length - 1);
    }


    public static int binarySearch(int[] array, int n, int left, int right) {
        if (array[array.length - 1] == n) return array.length - 1;
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

    public static int findPivot(int arr[], int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;
        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {5, 1};
        int[] arr2 = {8, 10, 0, 2, 4};
        int[] arr3 = {9, 1, 3, 8};
        System.out.println(brokenSearch(arr2, 4));
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }
}
