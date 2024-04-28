import java.util.Random;

public class ParallelBubbleSort {
    public static void main(String[] args) {
        int SIZE = 100000;
        int[] A = new int[SIZE];
        Random rand = new Random();

        // Fill array with random numbers
        for (int i = 0; i < SIZE; i++) {
            A[i] = rand.nextInt(SIZE);
        }

        int N = SIZE;
        int first;
        double start, end;

        start = System.nanoTime() / 1e9; // Get current time in seconds

        for (int i = 0; i < N - 1; i++) {
            first = i % 2;
            // #pragma omp parallel for shared(A, first)
            for (int j = first; j < N - 1; j += 1) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }

        end = System.nanoTime() / 1e9; // Get current time in seconds

        // Print sorted array
        for (int i = 0; i < N; i++) {
            System.out.print(" " + A[i]);
        }

        System.out.println("\n-------------------------\n Time Parallel= " + (end - start));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
