package org.example.yandex.sprint3;

public class BrokenArray {

    /*
-- ПРИНЦИП РАБОТЫ --
Сергей, привет!
Так как массив остается отсортированным, то мы можем использовать бинарный поиск, главное, найти место, куда сдвинут массив
(индекс опорного эл-та) и определить в какой части массива, относительного опорного эл-та, находится искомое число.
Далее, запустить бинарный поиск в этой части массива.

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

По условию задачи массив отсортирован и сдвинут, это гарантирует, что относительно pivot`a оба подмассива отсортированы
и к ним можно применить бинарный поиск.
Алгоритм посиска опорного элемента работает похожим, на бинарный поиск, образом.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Найти опорный эл-т - O(logN), т.к. рекусия, каждый следующий вызов функции делим массив на два части.
Бинарный поиск так же работает за O(logN).

В худшем и среднем случае получаем сложность - O(2lonN) ~ O(logN);
В лучшем - O(1)
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --

Размер входного массива мы не учитываем, хранением единичных переменных можно пренебречь -> Сложность O(1)

*/

    public static int brokenSearch(int[] arr, int k) {
        //Находим pivot
        int pivot = findPivot(arr, 0, arr.length - 1);
        // Если не нашли, то массив не сдвинут
        if (pivot == -1) return binarySearch(arr, k, 0, arr.length);
        //Проверяем, а не равен ли опорный эл-т искомому.
        if (arr[pivot] == k) return pivot;
        //Если искомый эл-т меньше опорного и больше либо равен первому, то его нужно искать в левой части
        if (arr[pivot] > k && arr[0] <= k) {
            return binarySearch(arr, k, 0, pivot - 1);
        }
        //Поиск в правой части
        return binarySearch(arr, k, pivot + 1, arr.length);
    }

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

    public static int findPivot(int arr[], int low, int high) {
        if (high < low)
            return -1;
        if (high == low)
            return low;
        int mid = (low + high) / 2;
        //Если mid больше следующего эл-та, то мы нашли pivot
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        // То же самое, но в обратную сторону
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        //Если массив нулевой эл-т больше центрального, то pivot находится в левой части
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        //Если нет, то в правой.
        return findPivot(arr, mid + 1, high);
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }
}
