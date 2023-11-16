package sorts.bucketsort;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[] test = new int[]{0, 2, 2, 2, 1, 1};
        new BucketSort().bucketSort(test);
        System.out.println(Arrays.toString(test));
    }

    public void bucketSort(int[] arr) {
        int[] bucket = new int[3];
        int insertionInd = 0;
        for (int num : arr) bucket[num]++;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[insertionInd] = i;
                insertionInd++;
            }
        }
    }
}
