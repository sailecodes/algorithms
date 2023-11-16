package sorts.mergesort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[]{8, 4, 6, 1, 3, 2};
        new MergeSort().mergeSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] leftSub = new int[(mid - start) + 1];
        int[] rightSub = new int[end - mid];

        for (int i = 0; i < leftSub.length; i++) leftSub[i] = arr[i + start];
        for (int i = 0; i < rightSub.length; i++) rightSub[i] = arr[i + mid + 1];

        int leftInd = 0;
        int rightInd = 0;
        int arrInd = start;

        while (leftInd < leftSub.length || rightInd < rightSub.length) {
            if (leftInd >= leftSub.length) {
                arr[arrInd] = rightSub[rightInd];
                rightInd++;
            } else if (rightInd >= rightSub.length) {
                arr[arrInd] = leftSub[leftInd];
                leftInd++;
            } else if (leftSub[leftInd] <= rightSub[rightInd]) {
                arr[arrInd] = leftSub[leftInd];
                leftInd++;
            } else {
                arr[arrInd] = rightSub[rightInd];
                rightInd++;
            }
            arrInd++;
        }
    }
}
