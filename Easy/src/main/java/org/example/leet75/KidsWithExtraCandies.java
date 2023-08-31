package org.example.leet75;

import java.util.*;

public class KidsWithExtraCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        TreeMap<Integer, Integer> kidsCandiesMap = new TreeMap<>();
        Boolean[] booleans = new Boolean[candies.length];
        for(int i = 0; i < candies.length; i++) {
            kidsCandiesMap.put(candies[i], i);
        }
        for(int i = 0; i < candies.length; i++) {
            try {
                kidsCandiesMap.higherEntry(candies[i] + extraCandies).getValue();
                booleans[i] = false;
            } catch (NullPointerException e) {
                booleans[i] = true;
            }
        }
        return Arrays.asList(booleans);
    }

    public static void main(String[] args) {
        int[] candies = new int[]{3, 4, 1, 5, 10, 6};
        System.out.println(kidsWithCandies(candies, 5));
    }
}
