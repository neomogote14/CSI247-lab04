import java.util.Arrays;
import java.util.Scanner;

public class Search {

    // a) linearSearch() - for double array
    public static int linearSearch(double[] arr, double key) {
        for (int i = 0; i < arr.length; i++) {
            // For doubles, direct == is ok for lab. In real projects use epsilon
            if (arr[i] == key) {
                return i;
            }
        }
        return -1; // not found
    }

    // b) binarySearch() - for int array with start and end
    public static int binarySearch(int[] arr, int key, int low, int high) {
        int comparisons = 0;
        while (low <= high) {
            comparisons++;
            int mid = low + (high - low) / 2;
            System.out.printf("Iteration %d: low=%d, high=%d, mid=%d (val=%d)%n", comparisons, low, high, mid, arr[mid]);

            if (arr[mid] == key)
                return mid;
            else if (key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Create 2 arrays, each to hold 50 values
        double[] array1 = new double[50]; // for linear search
        int[] array2 = new int[50]; // for binary search

        // 2. Fill array1 with 50 random doubles between 0 and 80 using for-loop
        for (int i = 0; i < 50; i++) {
            array1[i] = Math.random() * 80; // 0.0 <= x < 80.0
        }

        // 3. Fill array2 with first 50 positive even int values using while-loop
        int i = 0;
        int even = 2;
        while (i < 50) {
            array2[i] = even;
            even += 2;
            i++;
        }

        // Show arrays so you can test
        System.out.println("Array1 [Doubles 0-80]: " + Arrays.toString(array1));
        System.out.println("Array2 [Even Ints]: " + Arrays.toString(array2));
        System.out.println("====================================================");

        // 4. Menu loop
        String choice;
        do {
            System.out.print("\nChoose algorithm: [L]inear Search or [B]inary Search? Any other key to exit: ");
            choice = scanner.next().trim().toUpperCase();

            if (choice.equals("L")) {
                System.out.print("Enter a double value to search in Array1: ");
                double key = scanner.nextDouble();

                long start = System.nanoTime();
                int result = linearSearch(array1, key);
                long duration = System.nanoTime() - start;

                if (result!= -1)
                    System.out.println("Found at index " + result + " in Array1");
                else
                    System.out.println("Key not found in Array1");
                System.out.println("Execution Time: " + duration + " ns");

            } else if (choice.equals("B")) {
                System.out.print("Enter an integer value to search in Array2: ");
                int key = scanner.nextInt();

                long start = System.nanoTime();
                int result = binarySearch(array2, key, 0, array2.length - 1); // pass start and end
                long duration = System.nanoTime() - start;

                if (result!= -1)
                    System.out.println("Found at index " + result + " in Array2");
                else
                    System.out.println("Key not found in Array2");
                System.out.println("Execution Time: " + duration + " ns");
            }

        } while (choice.equals("L") || choice.equals("B"));

        System.out.println("Program terminated.");
        scanner.close();
    }
                                       }
