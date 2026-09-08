import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1, comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = low + (high - low) / 2;
            System.out.printf("Iteration %d: low=%d, high=%d, mid=%d (val=%d)%n", comparisons, low, high, mid, arr[mid]);

            if (arr[mid] == key) return mid;
            if (key < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {8, 18, 23, 29, 34, 42, 54, 63, 72, 85};

        System.out.print("Enter search key: ");
        int key = scanner.nextInt();

        long start = System.nanoTime();
        int result = binarySearch(arr, key);
        long duration = System.nanoTime() - start;

        System.out.println(result != -1 ? "Found at index " + result : "Key not found");
        System.out.println("Execution Time: " + duration + " ns");
        scanner.close();
    }
}
