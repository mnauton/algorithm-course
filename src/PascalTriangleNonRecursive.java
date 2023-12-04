import javax.swing.text.Style;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangleNonRecursive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter N (number of rows of Pascal Triangle):");
        int n = userInput.nextInt();
        getPascalTriangle(n);
    }

    private static int[][] getPascalTriangle(int n) {
        // Creating a 2-dimensional array: an array of n rows, then each row points to another array
        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            // Creating the variable rowSize for the length of each row
            int rowSize = i+1;
            // Creating the array for this row
            triangle[i] = new int[rowSize];
            if (i==0){
                // Edge case: the first row needs an array of just one element of value 1
                triangle[i][0] = 1;
                // Creating an array of tab characters to prepend to the row's values to create visual triangle
                char[] tabs = new char[n-1];
                // Filling the array
                Arrays.fill(tabs, '\t');
                // Before printing the row's elements I print the needed tabs to form the triangle
                System.out.println(new String(tabs) + triangle[0][0]);
            } else {
                int[] previousRow = triangle[i-1];
                int[] thisRow = triangle[i];
                char[] tabs = new char[n-1-i];
                // Filling the array
                Arrays.fill(tabs, '\t');
                // Before printing the row's elements I print the needed tabs to form the triangle
                System.out.print(new String(tabs));
                // next I calculate the row's elements
                for (int j = 0; j < rowSize; j++){
                    if (j == 0 || j == rowSize-1) {
                    // Edge case: the first and last element of each row contain a 1
                        thisRow[j] = 1;
                    }
                    else {
                        /* To calculate all the other elements, adding two elements from the previous row:
                        the element from the previous column + the element from the same column */
                        thisRow[j] = previousRow[j-1] + previousRow[j];
                    }
                    // I print the given element
                    System.out.print(thisRow[j] + "\t\t");
                }
                // After printing the row I print a linebreak
                System.out.println();
            }
        }
        return triangle;
    }
}
