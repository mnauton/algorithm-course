import java.util.Arrays;
import java.util.Scanner;
//Pascal Triangle using Recursion
public class PascalTriangleRecursive {
    public static int pascalTriangle(int row, int col) {
        if (col==0||col==row) {
            return 1;
        } else {
            return pascalTriangle(row-1,col-1) + pascalTriangle(row-1,col);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N (number of rows): ");
        int numRows = sc.nextInt();
        for (int row=0; row<numRows; row++) {

            char[] repeat = new char[numRows-row];
            // Filling the array
            Arrays.fill(repeat, '\t');
            System.out.print(new String(repeat));

            for (int col=0; col<=row;col++) {
                System.out.print(pascalTriangle(row, col) + "\t\t");
            }
            System.out.println();
        }
    }
}
