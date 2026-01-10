package dsa.maps;

import java.util.HashMap;
import java.util.Map;

public class containsDuplicate {
    public boolean hasDuplicate(int[] exampleArray) {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < exampleArray.length; i++) {
            Integer ourNumber = myMap.get(exampleArray[i]);
            if (ourNumber != null) {
                return true;

            } else {
                myMap.put(exampleArray[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 5 };
        var numberChecker = new containsDuplicate();
        System.out.println(numberChecker.hasDuplicate(numbers));
    }

}
