public class MergeSort {

    public void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = (array.length / 2);
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int j = mid; j < array.length; j++) {
            right[j - mid] = array[j];
        }
        mergeSort(left);
        mergeSort(right);

        mergeArray(array, left, right);
    }

    private void mergeArray(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
                // assign the value to K and then increment it by 1.
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }

    }

    public static void main(String[] args) {
        int[] arraySort = { 2, 6, 5, 1, 7, 4, 3 };
        MergeSort sortIt = new MergeSort();
        sortIt.mergeSort(arraySort);
        for (var x : arraySort) {
            System.out.print(x + " ");
        }
    }
}
