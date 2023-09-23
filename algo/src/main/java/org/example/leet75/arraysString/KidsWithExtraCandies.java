package org.example.leet75.arraysString;

import java.util.*;

public class KidsWithExtraCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> booleans = new ArrayList<>();
        int maxCandies = 0;
        for(int candi : candies) {
            if(candi > maxCandies) {
                maxCandies = candi;
            }
        }
        for(int c : candies) {
            if((c + extraCandies) < maxCandies) {
                booleans.add(false);
            } else {
                booleans.add(true);
            }
        }
        return booleans;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{3, 4, 1, 5, 10, 6};
        System.out.println(kidsWithCandies(candies, 5));
    }
}
