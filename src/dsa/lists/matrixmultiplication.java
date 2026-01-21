package dsa.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class matrixmultiplication {
    Map<Integer, List<Integer>> numbersToMultiply = new HashMap<>();

    public List<Integer> productExceptSelf(int[] nums) {
        List<Integer> producList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> associativeList = new ArrayList<>();
            int k = 0;
            if (k == i) {
                k = i + 1;
            } else {
                k = 0;
            }
            while ((k != i) && (k < nums.length)) {
                associativeList.add(nums[k]);
                k++;
            }
            k++;
            while (k != i && k < nums.length) {
                associativeList.add(nums[k]);
                k++;
            }
            numbersToMultiply.put(i, associativeList);

        }
        Set<Integer> newNums = numbersToMultiply.keySet();
        for (var thing2 : newNums) {
            List<Integer> productionsquare = numbersToMultiply.get(thing2);
            int product = productionsquare.get(0);
            for (var thing1 : productionsquare) {
                System.out.print(thing1 + " ");
            }
            System.out.println();

        }

        return producList;

    }

    public static int getProduct(List<Integer> container) {
        int product = container.get(0);
        for (int j = 0; j < container.size() - 1; j++) {
            product = product * container.get(j + 1);
        }
        return product;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        var item = new matrixmultiplication();
        // item.productExceptSelf(nums);
        // List<Integer> newList =
        // for (var thing : newList) {
        // System.out.print(thing + " ");
        // }

    }
}
