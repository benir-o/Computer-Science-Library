package dsa.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class matrixmultiplication {
    Map<Integer, List<Integer>> numbersToMultiply = new HashMap<>();

    public int[] productExceptSelf(int[] nums) {
        List<Integer> productList = new ArrayList<>();
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
            productList.add(getProduct(productionsquare));
        }
        return convertToArray(productList);
    }

    public static int getProduct(List<Integer> container) {
        int product = container.get(0);
        for (int j = 0; j < container.size() - 1; j++) {
            product = product * container.get(j + 1);
        }
        return product;
    }

    public static int[] convertToArray(List<Integer> container) {
        int[] products = new int[container.size()];
        for (int h = 0; h < products.length; h++) {
            products[h] = container.get(h);
        }
        return products;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 5, 3, 4 };
        var item = new matrixmultiplication();

        int[] newList = item.productExceptSelf(nums);
        for (var thing : newList) {
            System.out.print(thing + " ");
        }

    }
}
