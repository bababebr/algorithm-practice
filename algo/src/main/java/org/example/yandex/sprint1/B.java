package org.example.yandex.sprint1;

import java.util.Scanner;

public class B {

    private static boolean checkParity(int a, int b, int c) {
        boolean aEven = a%2 == 0;
        boolean bEven = b%2 == 0;
        boolean cEvent = c%2 == 0;

        if(aEven == bEven && bEven == cEvent) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (checkParity(a, b, c)) {
            System.out.println("WIN");
        } else {
            System.out.println("FAIL");
        }
        scanner.close();
    }

}