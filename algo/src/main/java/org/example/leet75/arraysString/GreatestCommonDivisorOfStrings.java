package org.example.leet75.arraysString;

import java.util.HashSet;

public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        int gcd = getGcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    public int getGcd(int a, int b) {
        if (b==0) return a;
        return getGcd(b,a%b);
    }

    public static void main(String[] args) {

    }

}
