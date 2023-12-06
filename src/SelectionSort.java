import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter list of numbers to sort (separated by commas):");
        // Allowing the user to input the numbers in one go
        String numbersString = userInput.nextLine();
        /* Creating an array of Strings, filling it in with Strings,
        and separating each string by commas */
        String[] numbersStringArr = numbersString.split(",");
        // Creating a new array of integers of the size of the previous array
        int[] numbers = new int[numbersStringArr.length];
        // Iterating through the array
        for(int i = 0; i < numbersStringArr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStringArr[i].trim());
        }

        System.out.println("Before:");
        System.out.println(Arrays.toString(numbers));

        selectionSort(numbers);

        System.out.println("\nAfter:");
        System.out.println(Arrays.toString(numbers));
    }

    private static void selectionSort(int[] numbers) {
        int length = numbers.length;

        for (int i = 0; i < length - 1; i++){
            int min = numbers[i];
            int indexOfMin = i;
            for (int j = i + 1; j < length; j++){
                if (numbers[j] < min) {
                    min = numbers[j];
                    indexOfMin = j;
                }
            }
            swap(numbers, i, indexOfMin);
        }
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
