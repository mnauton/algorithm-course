public class Recursion1V0
{
    public static void main (String args[])
    {
        count(3);
        System.out.println();
    }
    public static void count (int index)
    {
        if (index > 2)
            count(index+1);
        System.out.print(index);
    }
}