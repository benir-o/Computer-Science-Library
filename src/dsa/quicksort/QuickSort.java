package dsa.quicksort;

public class QuickSort {

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public void qsort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(array, left, right);
        qsort(array, left, pivot - 1);
        qsort(array, pivot + 1, right);
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = -1;
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);

        return i + 1;
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 3, -1, 5, 4, -3, 0 };
        var sortItem = new QuickSort();
        sortItem.qsort(numbers, 0, numbers.length - 1);

        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }

}
