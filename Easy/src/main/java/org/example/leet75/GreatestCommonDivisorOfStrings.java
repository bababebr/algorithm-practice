package org.example.leet75;

import java.util.HashSet;

public class GreatestCommonDivisorOfStrings {

    private static HashSet<String> splitByCharsCount(String str, int count) {
        HashSet<String> set = new HashSet<>();
        if (str.length() % count == 0) {
            for (int i = 0; i < str.length(); i += count) {
                set.add(str.substring(i, i + count));
            }
        } else {
            for (int i = 0; i < (str.length() - (str.length() % count)); i += count) {
                set.add(str.substring(i, i + count));
            }
            set.add(str.substring((str.length() - (str.length() % count))));
        }
        return set;
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(str2.length() > str1.length()) {
            str2 = str2.substring(0, str1.length());
        }
        System.out.println(str2);
        int length = str2.length();
        while (length > 0) {
            HashSet<String> splitStr1 = splitByCharsCount(str1, length);
            System.out.println(splitStr1);
            if(splitStr1.size() == 1) {
                if(splitStr1.contains(str2.substring(0, length))) {
                    return str2.substring(0, length);
                }
            }
            length--;
        }
        return "";
    }

    public static void main(String[] args) {
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        String result = "TAUXX";
        gcdOfStrings(str1, str2);
        //System.out.println(splitByCharsCount(str1, str1.length()));
    }

}
