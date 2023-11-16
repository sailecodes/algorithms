package sorts.quicksort;

import sorts.mergesort.MergeSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] test = new int[]{8, 4, 6, 1, 3, 2};
        new QuickSort().quickSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int partitionInd = partition(arr, start, end);
        quickSort(arr, start, partitionInd - 1);
        quickSort(arr, partitionInd + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        randomizePivot(arr, start, end);
        int pivot = arr[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left != end && arr[left] <= pivot) left++;
            while (right != start && arr[right] > pivot) right--;

            if (left < right) swap(arr, left, right);
        }

        swap(arr, start, right);

        return right;
    }

    private void randomizePivot(int[] arr, int start, int end) {
        Random rand= new Random();

        int pivotInd = rand.nextInt(end - start) + start;
        int tmp = arr[pivotInd];
        arr[pivotInd] = arr[start];
        arr[start] = tmp;
    }

    private void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
