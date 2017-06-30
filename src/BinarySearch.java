import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Created by pshen on 2017/6/30.
 */
public class BinarySearch {
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        int[] list = new In(args[1]).readAllInts();
        int length = list.length;
        for (int i = 0; i < length; i++)
        {
            int key = list[i];
            if (rank(key, whitelist) < 0)
                StdOut.println(key);
        }
    }
}
