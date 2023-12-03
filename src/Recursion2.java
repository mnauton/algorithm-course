public class Recursion2
{
    public static void main (String args[])
    {
        upAndDown(2);
        System.out.println();
    }
    public static void upAndDown (int n)
    {
        System.out.print ("\nLevel: " + n);
        if (n < 4)
            upAndDown (n+1);
        System.out.print ("\nLEVEL: " + n);
    }
}