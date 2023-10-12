package org.example.yandex.sprint3;

public class BinaryString {
    public static String asBinaryString(int n) {
        if (n < 0) {
            return "-" + asBinaryString(-n);
        }
        if (n == 0 || n == 1) {
            return Integer.toString(n);
        }
        int lastDigit = n % 2;
        return asBinaryString(n / 2) + Integer.toString(lastDigit);
    }

    public static void main(String[] args) {
        System.out.println(asBinaryString(32323));
    }
}
