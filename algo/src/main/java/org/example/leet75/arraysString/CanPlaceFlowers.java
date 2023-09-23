package org.example.leet75.arraysString;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int possiblePlants = contZeros(flowerbed);
        return n <= possiblePlants;
    }

    private static int contZeros(int[] array) {
        int count = 0;
        if (array.length == 1 && array[0] == 0) {
            return 1;
        }
        if (array[0] == 0 && array[1] == 0) {
            array[0] = 1;
            count++;
        }
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == 0 && array[i - 1] == 0 && array[i + 1] == 0) {
                array[i] = 1;
                count++;
            }
        }
        if (array[array.length - 1] == 0 && array[array.length - 2] == 0) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 0, 0, 0, 0, 0};
        System.out.println(contZeros(array));
    }

}
