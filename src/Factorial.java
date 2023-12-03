public class Factorial {

    public static void main(String args[]) {
//        for (int i = 1; i < 10; i++)
//            System.out.println(i + "! = " + findFactorial(i));
        System.out.println(4 + "! = " + findFactorial(4));
    }

    public static int findFactorial(int number) {
        int factorialminus1;
        if ((number == 1) || (number == 0))
            return 1;
        else {
            factorialminus1 = findFactorial(number - 1);
            return number * factorialminus1;
        }
    }
}
