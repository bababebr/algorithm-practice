package org.example.leet75.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        HashSet<Integer> zerosIdx = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zerosIdx.add(i);
            }
        }
        System.out.println(zerosIdx);
        int zerosCount = zerosIdx.size();
        ArrayList<Integer> newNums = new ArrayList<>();
        System.out.println(newNums);
        for(int i = 0; i < nums.length; i++) {
            if(!zerosIdx.contains(i)){
                newNums.add(nums[i]);
            }
        }
        System.out.println(newNums);
        for(int i = nums.length - zerosCount; i < nums.length; i++) {
            newNums.add(0);
        }
        for(int i = 0; i <nums.length; i++) {
            nums[i] = newNums.get(i);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 4, 0, 5};
        moveZeroes(nums);
    }
}
