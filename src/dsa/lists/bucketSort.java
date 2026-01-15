package dsa.lists;

import java.util.*;

public class bucketSort {
    public int[] topKFrequentElemnts(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
            // Populating the hashmap while incrementing values.
        }
        Set<Integer> mapKeys = frequencyMap.keySet();

        for (int uniqueNumber : mapKeys) {
            int frequency = frequencyMap.get(uniqueNumber);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(uniqueNumber);
        }

        int[] result = new int[k];
        int counter = 0;
        for (int position = bucket.length - 1; position >= 0 && counter < k; position--) {
            if (bucket[position] != null) {
                for (Integer myInteger : bucket[position]) {
                    result[counter] = myInteger;
                    counter++;
                }
            }

        }

        return result;
    }

}
