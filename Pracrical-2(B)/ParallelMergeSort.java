import java.util.Random;

public class ParallelMergeSort {
    public static void main(String[] args) {
        int n = 10;
        double start, stop;

        int[] data = new int[n];
        int[] tmp = new int[n];

        generateList(data, n);
        System.out.println("List Before Sorting...");
        printList(data);

        start = System.nanoTime() / 1e9; // Get current time in seconds

        mergesort(data, n, tmp);

        stop = System.nanoTime() / 1e9; // Get current time in seconds

        System.out.println("\nList After Sorting...");
        printList(data);
        System.out.println("\nTime: " + (stop - start));
    }

    static void generateList(int[] x, int n) {
        for (int i = 0; i < n; i++) {
            x[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int j = rand.nextInt(n);
            int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }
    }

    static void printList(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }

    static void merge(int[] X, int n, int[] tmp) {
        int i = 0;
        int j = n / 2;
        int ti = 0;
        while (i < n / 2 && j < n) {
            if (X[i] < X[j]) {
                tmp[ti++] = X[i++];
            } else {
                tmp[ti++] = X[j++];
            }
        }
        while (i < n / 2) {
            tmp[ti++] = X[i++];
        }
        while (j < n) {
            tmp[ti++] = X[j++];
        }
        System.arraycopy(tmp, 0, X, 0, n);
    }

    static void mergesort(int[] X, int n, int[] tmp) {
        if (n < 2) return;

        // Split the array into two halves
        int[] left = new int[n / 2];
        int[] right = new int[n - n / 2];
        System.arraycopy(X, 0, left, 0, n / 2);
        System.arraycopy(X, n / 2, right, 0, n - n / 2);

        // Sort each half recursively
        mergesort(left, n / 2, tmp);
        mergesort(right, n - n / 2, tmp);

        // Merge the sorted halves
        merge(left, n / 2, right, n - n / 2, X);
    }

    static void merge(int[] left, int leftSize, int[] right, int rightSize, int[] X) {
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                X[k++] = left[i++];
            } else {
                X[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            X[k++] = left[i++];
        }
        while (j < rightSize) {
            X[k++] = right[j++];
        }
    }
}
