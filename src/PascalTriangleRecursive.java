import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangleRecursive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter N (number of rows of Pascal Triangle):");
        int n = userInput.nextInt();
        int[][] triangle = getPascalTriangle(n);
        System.out.println(getPascalTriangleRepresentation(triangle));
    }

    private static int[][] getPascalTriangle(int n) {
        // create base case so that it stops when n is reached

        // recursive method called for calculation of previous row numbers
        int[][] triangle;
        // base case
        if (n==0) {
            return new int[0][0];
        }
        // base case
        if (n==1) {
            triangle = new int[1][1];
            triangle[0][0] = 1;
            return triangle;
        }

        // Creating a 2-dimensional array: an array of n rows, and an array for each row
        triangle = new int[n][];

        for (int i = 1; i < n; i++) {
            // Creating the variable rowSize for the length of each row
            int rowSize = i+1;
            triangle[i] = new int[rowSize];

                /* Edge cases for first and last number of each row:
            they are equal to the first and the last number of previous row */
            int[][] lastTriangle = getPascalTriangle(n-1);
            int[] thisRow = triangle[i];

            if (i== 0 || i == rowSize-1) {
                thisRow[i] = 1;
            }
            else {
                /* To calculate all the other numbers, add 2 numbers from the previous row:
                the number from the previous index + the number from the same index */
                thisRow[i] = lastTriangle[-1][i] + lastTriangle[-1][i+1];
            }

        }

        return triangle;

    }

    // Method to print out the triangle
    private static String getPascalTriangleRepresentation(int[][] pascalTriangle){
        String result = "";

        // Looping through each row of the triangle
        for (int i = 0; i < pascalTriangle.length; i++) {
            String rowString = "";
            /* Creating an array of characters of length - 1 (last row doesn't need any tab)
            and - i (each row needs 1 tab less) */
            char[] repeat = new char[pascalTriangle.length-1-i];
            // Filling the array
            Arrays.fill(repeat, '\t');
            rowString += new String(repeat);

            /* Enhanced for to loop through the triangle's numbers and add 2 tabs in between each number,
            as well as a new line at the end of each row */
            for (int digit : pascalTriangle[i]){
                rowString += digit + "\t\t";
            }
            result += rowString + "\n";
        }

        return result;
    }


}
