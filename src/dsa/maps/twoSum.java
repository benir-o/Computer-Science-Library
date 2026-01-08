package dsa.maps;

import java.util.*;

public class twoSum {

    Map<Integer, Integer> complements = new HashMap<>();

    public int[] mySum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]);
            if (complementIndex != null) {
                return new int[] { i, complementIndex };

            }
            complements.put(target - nums[i], i);
        }
        return nums;

    }

    public static void main(String[] args) {

    }
}
