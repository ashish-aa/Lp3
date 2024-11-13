import java.util.*;

public class quick {

    // Function for deterministic Quick Sort partition
    public static int deterministicPartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] >= pivot) right--;
            if (left <= right) {
                // Swap arr[left] and arr[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // Swap pivot with arr[right]
        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;
        return right;
    }

    public static void deterministicQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = deterministicPartition(arr, low, high);
            deterministicQuickSort(arr, low, pivotIndex - 1);
            deterministicQuickSort(arr, pivotIndex + 1, high);
        }
    }

    // Function for randomized Quick Sort partition
    public static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);
        // Swap arr[low] and arr[pivotIndex]
        int temp = arr[low];
        arr[low] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] >= pivot) right--;
            if (left <= right) {
                // Swap arr[left] and arr[right]
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // Swap pivot with arr[right]
        temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;
        return right;
    }

    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex + 1, high);
        }
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        while (true) {
            System.out.println("1. Deterministic Quick Sort");
            System.out.println("2. Randomized Quick Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.println("Original array for deterministic quick sort:");
                printArray(arr1);

                deterministicQuickSort(arr1, 0, arr1.length - 1);

                System.out.println("Sorted array (Deterministic):");
                printArray(arr1);
            } else if (ch == 2) {
                System.out.println("\nOriginal array for randomized quick sort:");
                printArray(arr2);

                randomizedQuickSort(arr2, 0, arr2.length - 1);

                System.out.println("Sorted array (Randomized):");
                printArray(arr2);
            } else if (ch == 3) {
                break;
            }
        }

        sc.close();
    }
}
