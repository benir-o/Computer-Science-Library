package dsa.lists;

import java.util.*;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();
            int j = 0;
            int k = i + 1;
            while (j < i) {
                leftList.add(nums[j]);
                // System.out.println(leftList.get(0));
                j++;
            }
            // Compute the product of the left List
            int leftProduct = getProduct(leftList);
            while (k < nums.length) {
                rightList.add(nums[k]);
                // System.out.println(rightList.get(0));
                k++;
            }
            // Compute the product of the right List
            int rightProduct = getProduct(rightList);
            // Compute what we get from both lists
            int positionalInteger = leftProduct * rightProduct;

            newList.add(positionalInteger);
        }
        return convertToArray(newList);

    }

    public static int getProduct(List<Integer> container) {
        int product;
        if (container.isEmpty()) {
            return 1;
        } else {
            product = container.get(0);
            for (int j = 0; j < container.size() - 1; j++) {
                product = product * container.get(j + 1);
            }

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
        Solution s1 = new Solution();
        int[] nums = { 1, 2, 3 };
        int[] products = s1.productExceptSelf(nums);
        for (var item : products) {
            System.out.print(item + " ");
        }
    }
}
