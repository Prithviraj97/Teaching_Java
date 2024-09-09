package Algorithms;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SearchSortApp {

    // Main function
    public static void main(String[] args) {
        String[] options = {"Search", "Sort"};
        String choice = (String) JOptionPane.showInputDialog(null, "Choose an option", "Search/Sort",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if ("Search".equals(choice)) {
            performSearch();
        } else if ("Sort".equals(choice)) {
            performSort();
        }
    }

    // Method for performing search
    private static void performSearch() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a file with numbers separated by commas");

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Read the numbers from the file and store them in an array
                String content = Files.readString(selectedFile.toPath());
                int[] numbers = Arrays.stream(content.split(","))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();

                // Get the target number from the user
                String targetInput = JOptionPane.showInputDialog("Enter the number to search for:");
                int target = Integer.parseInt(targetInput);

                // Let user choose between Linear Search or Binary Search
                String[] searchOptions = {"Linear Search", "Binary Search"};
                String searchChoice = (String) JOptionPane.showInputDialog(null, "Choose a search method",
                        "Search Method", JOptionPane.QUESTION_MESSAGE, null, searchOptions, searchOptions[0]);

                long startTime = System.nanoTime();
                int resultIndex;

                // Perform the chosen search
                if ("Linear Search".equals(searchChoice)) {
                    resultIndex = linearSearch(numbers, target);
                } else {
                    Arrays.sort(numbers); // Binary search requires sorted data
                    resultIndex = binarySearch(numbers, target);
                }
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                // Display result
                if (resultIndex != -1) {
                    JOptionPane.showMessageDialog(null, "Number found at index: " + resultIndex + "\nTime taken: " + duration + " ns");
                } else {
                    JOptionPane.showMessageDialog(null, "Number not found.");
                }

            } catch (IOException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error processing file or input. Please try again.");
            }
        }
    }

    // Method for performing sorting
    private static void performSort() {
        // Get numbers input from user
        String input = JOptionPane.showInputDialog("Enter numbers separated by commas:");
        int[] numbers = Arrays.stream(input.split(","))
                              .mapToInt(Integer::parseInt)
                              .toArray();

        // Let user choose between Bubble Sort or Merge Sort
        String[] sortOptions = {"Bubble Sort", "Merge Sort"};
        String sortChoice = (String) JOptionPane.showInputDialog(null, "Choose a sorting method",
                "Sorting Method", JOptionPane.QUESTION_MESSAGE, null, sortOptions, sortOptions[0]);

        long startTime = System.nanoTime();

        // Perform the chosen sorting method
        if ("Bubble Sort".equals(sortChoice)) {
            bubbleSort(numbers);
        } else {
            mergeSort(numbers, 0, numbers.length - 1);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Display sorted array and time taken
        String sortedArray = Arrays.toString(numbers);
        JOptionPane.showMessageDialog(null, "The sorted array is: " + sortedArray + "\nTime taken: " + duration + " ns");
    }

    // Linear Search Algorithm
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search Algorithm
    private static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Bubble Sort Algorithm
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort Algorithm
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merge function for Merge Sort
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

