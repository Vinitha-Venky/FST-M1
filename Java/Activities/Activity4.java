package hello;

public class Activity4 {

    public static void main(String[] args) {
        // Initialize an array with numbers in random order
        int[] array = {29, 10, 14, 37, 13};

        // Display the array before sorting
        System.out.println("Array before sorting:");
        printArray(array);

        // Sort the array using insertion sort
        insertionSort(array);

        // Display the array after sorting
        System.out.println("Array after sorting:");
        printArray(array);
    }

    // Method to perform insertion sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}