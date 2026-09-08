import java.util.Arrays;
import java.util.Scanner;

public class Search {
  public static int linearSearch(double[] arr, double key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int key, int low, int high) {
        int comparisons = 0;
        while (low <= high) {
            comparisons++;
            int mid = low + (high - low) / 2;
            System.out.printf("Iteration %d: low=%d, high=%d, mid=%d (val=%d)%n", 
                              comparisons, low, high, mid, arr[mid]);

            if (arr[mid] == key) return mid;
            if (key < arr[mid]) high = mid - 1;
              else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] array1 = new double[50];
        int[] array2 = new int[50];

        for (int i = 0; i < 50; i++) {
            array1[i] = Math.random() * 80;
        }

        int i = 0, even = 2;
        while (i < 50) {
            array2[i] = even;
            even += 2;
            i++;
        }

        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));

        String choice;
        do {
            System.out.print("\nChoose algorithm [L/B] or any other key to exit: ");
            choice = scanner.next().trim().toUpperCase();

            if (choice.equals("L")) {
                System.out.print("Enter double key: ");
                double key = scanner.nextDouble();
                long start = System.nanoTime();
                int res = linearSearch(array1, key);
                long time = System.nanoTime() - start;
                
                System.out.println(res != -1 ? "Found at index " + res : "Key not found");
                System.out.println("Time: " + time + " ns");

            } else if (choice.equals("B")) {
                System.out.print("Enter int key: ");
                int key = scanner.nextInt();
                long start = System.nanoTime();
                int res = binarySearch(array2, key, 0, array2.length - 1);
                long time = System.nanoTime() - start;

                System.out.println(res != -1 ? "Found at index " + res : "Key not found");
                System.out.println("Time: " + time + " ns");
            }
        } while (choice.equals("L") || choice.equals("B"));

        scanner.close();
    }
}
