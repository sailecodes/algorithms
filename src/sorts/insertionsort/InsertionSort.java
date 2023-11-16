package sorts.insertionsort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] test = new int[]{8, 4, 6, 1, 3, 2};
        new InsertionSort().insertionSort(test);
        System.out.println(Arrays.toString(test));
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (arr[j] <= arr[j + 1]) break;

                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
    }
}
