package dsa.quicksort;

public class quicksort1 {
    void swap(int[] myArray, int a, int b) {
        int temp = myArray[a];
        myArray[a] = myArray[b];
        myArray[b] = temp;
    }

    void sortArray(int[] myset, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(myset, left, right);
        sortArray(myset, left, pivot - 1);
        sortArray(myset, pivot + 1, right);

    }

    int partition(int[] theSet, int low, int high) {
        int mypivot = theSet[high];
        int i = -1;
        for (int j = 0; j < theSet.length - 1; j++) {
            if (theSet[j] < mypivot) {
                i++;
                swap(theSet, i, j);
            }
        }
        swap(theSet, i + 1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        var test1 = new quicksort1();
        int[] testArray = { 3, -2, -1, 34, 15, 11, 4, 8 };
        test1.sortArray(testArray, 0, testArray.length - 1);
        for (var item : testArray) {
            System.out.print(item + " ");
        }
    }
}
