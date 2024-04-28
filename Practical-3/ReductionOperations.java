import java.util.Scanner;

public class ReductionOperations {
    static void minReduction(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < minValue) {
                minValue = num;
            }
        }
        System.out.println("Minimum value: " + minValue);
    }

    static void maxReduction(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        System.out.println("Maximum value: " + maxValue);
    }

    static void sumReduction(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
    }

    static void averageReduction(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;
        System.out.println("Average: " + average);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        minReduction(arr);
        maxReduction(arr);
        sumReduction(arr);
        averageReduction(arr);
    }
}
