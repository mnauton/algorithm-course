import java.util.Arrays;
import java.util.Scanner;
//Pascal Triangle using Recursion
public class PascalTriangleRecursive {
    public static int pascalTriangle(int row, int col) {
        // This is the base case
        if (col==0||col==row) {
            return 1;
        } else {
            // Making progress case
            /* The calculation for each element is the sum of the previous row's
            previous column and following column. I get these two values recursively. */
            return pascalTriangle(row-1,col-1) + pascalTriangle(row-1,col);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N (number of rows): ");
        int numRows = sc.nextInt();
        // Looping through the rows
        for (int row=0; row<numRows; row++) {

            char[] repeat = new char[numRows-row];
            // Filling the array with tabs
            Arrays.fill(repeat, '\t');
            // Printing the tabs to form the triangle
            System.out.print(new String(repeat));
            // Looping through the columns of each row
            for (int col=0; col<=row; col++) {
                // Calling the pascalTriangle method to get its value for each element
                System.out.print(pascalTriangle(row, col) + "\t\t");
            }
            // Printing a line break after a row
            System.out.println();
        }
    }
}
