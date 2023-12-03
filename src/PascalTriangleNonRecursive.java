import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangleNonRecursive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter N (number of rows of Pascal Triangle):");
        int n = userInput.nextInt();
        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            int rowSize = i+1;
            triangle[i] = new int[rowSize];
            if (i==0){
                triangle[i][0] = 1;
            } else {
                int[] previousRow = triangle[i-1];
                int[] thisRow = triangle[i];
                for (int j = 0; j < rowSize; j++){
                    if (j == 0 || j == rowSize-1) {
                        thisRow[j] = 1;
                    }
                    else {
                        thisRow[j] = previousRow[j-1] + previousRow[j];
                    }
                }
            }
        }
        System.out.println(getPascalTriangleRepresentation(triangle));
    }
    
    public static String getPascalTriangleRepresentation(int[][] triangle){
        String result = "";

        for (int i = 0; i < triangle.length; i++) {

            String rowString = "";
            char[] repeat = new char[triangle.length-1-i];
            Arrays.fill(repeat, '\t');
            rowString += new String(repeat);

            for (int digit : triangle[i]){
               rowString += digit + "\t\t";
            }
            result += rowString + "\n";
        }

        return result;
    }
}
