package recursion;

public class TowersOfHanoi {

    static void towerOfHanoi(int n, char start, char mid, char end)
    {
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  start + " to rod " + end);
            return;
        }
        towerOfHanoi(n - 1, start, end, mid);
        System.out.println("Take disk " + n + " from rod " +  start + " to rod " + end);
        towerOfHanoi(n - 1, mid, start, end);
    }

    public static void main(String args[])
    {
        int n = 3;
        towerOfHanoi(n,'A','B', 'C');
    }
}
