package org.example.yandex.sprint3;

import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] result = new int[arr.length];
        int l = left;
        int r = mid;
        int k = 0;
        while (l < mid && r < right) {
            if (arr[l] <= arr[r]) {
                result[k] = arr[l];
                l++;
            } else {
                result[k] = arr[r];
                r++;
            }
            k++;
        }

        while (l < mid) {
            result[k] = arr[l];
            l++;
            k++;
        }

        while (r < right) {
            result[k] = arr[r];
            r++;
            k++;
        }
        return result;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left < right) {
            int m = left + (right-left) / 2;
            merge_sort(arr, left, m);
            merge_sort(arr, m + 1, right);
            arr = merge(arr, left, m, right);
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);

        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        System.out.println(Arrays.toString(c));
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}