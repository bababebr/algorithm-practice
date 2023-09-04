package org.example.leet75.arraysString;

import java.util.Arrays;
import java.util.TreeMap;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
