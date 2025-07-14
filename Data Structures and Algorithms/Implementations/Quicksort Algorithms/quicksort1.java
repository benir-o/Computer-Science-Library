
public class quicksort1 {

    public void swapArrayElements(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void quicksortArray(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partitionArray(array, left, right);
        quicksortArray(array, pivot + 1, right);
        quicksortArray(array, left, pivot - 1);

    }

    public int partitionArray(int[] testArray, int left, int right) {
        int i = -1;
        int pivot = testArray[right];

        for (int j = 0; j < testArray.length - 1; j++) {
            if (testArray[j] < pivot) {
                i++;
                swapArrayElements(testArray, i, j);
            }
        }
        swapArrayElements(testArray, i + 1, right);
        return i + 1;
    }

    public static void main(String[] args) {
        var item = new quicksort1();
        int[] digits = { 3, 52, 2, 4, 9, 7, 6 };
        item.quicksortArray(digits, 0, digits.length - 1);
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i] + " ");
        }
    }

}
