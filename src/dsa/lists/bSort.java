package dsa.lists;

import java.util.*;

public class bSort {

    public int[] returnTopElements(int[] numbersToFind, int k) {
        List<Integer>[] bucket = new List[numbersToFind.length + 1];
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (var num : numbersToFind) {
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> setofIntegers = numberMap.keySet();

        for (Integer myInt : setofIntegers) {
            int frequency = numberMap.get(myInt);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(myInt);
        }

        int[] myResults = new int[k];
        int count = 0;

        for (int position = bucket.length - 1; count < k && position >= 0; position--) {
            if (bucket[position] != null) {
                for (int freqNuInteger : bucket[position]) {
                    myResults[count] = freqNuInteger;
                    count++;
                }
            }

        }
        return myResults;

    }

    public static void main(String[] args) {
        bSort bucketSort = new bSort();
        int[] numbersss = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 5, 5, 5, 5, 5, 5, 5 };
        int[] freqElements = bucketSort.returnTopElements(numbersss, 2);
        for (var number : freqElements) {
            System.out.print(number + " ");
        }
    }
}
