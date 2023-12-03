import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangleNonRecursive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter N (number of rows of Pascal Triangle):");
        int n = userInput.nextInt();
        // Creating a 2-dimensional array: an array of n rows, and an array for each row
        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            // Creating the variable rowSize for the length of each row
            int rowSize = i+1;
            triangle[i] = new int[rowSize];
            // Edge case: the first row only needs 1 number and starts with integer 1
            if (i==0){
                triangle[i][0] = 1;
            } else {
                /* Edge cases for first and last number of each row:
                they are equal to the first and the last number of previous row */
                int[] previousRow = triangle[i-1];
                int[] thisRow = triangle[i];
                for (int j = 0; j < rowSize; j++){
                    if (j == 0 || j == rowSize-1) {
                        thisRow[j] = 1;
                    }
                    else {
                        /* To calculate all the other numbers, add 2 numbers from the previous row:
                        the number from the previous index + the number from the same index */
                        thisRow[j] = previousRow[j-1] + previousRow[j];
                    }
                }
            }
        }
        System.out.println(getPascalTriangleRepresentation(triangle));
    }

    // Method to print out the triangle
    public static String getPascalTriangleRepresentation(int[][] triangle){
        String result = "";

        // Looping through each row of the triangle
        for (int i = 0; i < triangle.length; i++) {
            String rowString = "";
            /* Creating an array of characters of length - 1 (last row doesn't need any tab)
            and - i (each row needs 1 tab less) */
            char[] repeat = new char[triangle.length-1-i];
            // Filling the array
            Arrays.fill(repeat, '\t');
            rowString += new String(repeat);

            /* Enhanced for to loop through the triangle's numbers and add 2 tabs in between each number,
            as well as a new line at the end of each row */
            for (int digit : triangle[i]){
               rowString += digit + "\t\t";
            }
            result += rowString + "\n";
        }

        return result;
    }
}
