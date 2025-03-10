import java.util.Arrays;

public class ExponentialSearch {
    // Exponential Search Algorithm
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;
        
        // If the target is at the first index
        if (arr[0] == target) return 0;
        
        // Find range for binary search by doubling the index
        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }

        // Perform binary search in the found range
        return binarySearch(arr, i / 2, Math.min(i, n - 1), target);
    }

    // Binary Search (Helper Function)
    public static int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 50, 70, 80, 100, 120};
        int target = 70;

        int result = exponentialSearch(arr, target);
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
}
