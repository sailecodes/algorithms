package searches.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 4, 8, 11, 13, 27};
        System.out.println(new BinarySearch().binarySearchIte(test, 8, 0, test.length - 1));
    }

    public boolean binarySearchRec(int[] arr, int target, int start, int end) {
        if (start > end) return false;

        int mid = ((end - start) / 2) + start;

        if (arr[mid] == target) return true;
        else if (arr[mid] > target) return binarySearchRec(arr, target, start, mid - 1);
        else return binarySearchRec(arr, target, mid + 1, end);
    }

    public boolean binarySearchIte(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = ((end - start) / 2) + start;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
