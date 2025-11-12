public class FCFS {
    public void prioritize(int[] arrivaltimes) {
        int inputLength = arrivaltimes.length;
        if (inputLength < 2) {
            return;
            // my base case for the sorting
        }
        int mid = inputLength / 2;
        int[] left = new int[mid];
        int[] right = new int[inputLength - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arrivaltimes[i];
        }
        for (int j = mid; j < inputLength; j++) {
            right[j - mid] = arrivaltimes[j];
        }
        prioritize(left);
        prioritize(right);

        // Merge Left and Right
        merge(arrivaltimes, left, right);

    }

    public void merge(int[] mergedArray, int[] leftarray, int[] rightarray) {
        int i = 0, j = 0, k = 0;
        while (i < leftarray.length && j < rightarray.length) {
            if (leftarray[i] <= rightarray[j]) {
                mergedArray[k] = leftarray[i];
                i++;
            } else {
                mergedArray[k] = rightarray[j];
                j++;
            }
            k++;
        }
        while (i < leftarray.length) {
            mergedArray[k] = leftarray[i];
            i++;
            k++;
        }
        while (j < rightarray.length) {
            mergedArray[k] = rightarray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] Arrivaltimes = { 1, 4, 18, 2, 34, 5, 16, 25, 15, 13 };
        FCFS myCpu = new FCFS();
        myCpu.prioritize(Arrivaltimes);
        for (int h = 0; h < Arrivaltimes.length; h++) {
            System.out.print(Arrivaltimes[h] + " ");
        }
    }
}
