import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/21.
 */
public class Count
{
    public static void main(String[] args)
    {
        Alphabet alpha = new Alphabet(args[0]);
        int R = alpha.R();
        int[] count = new int[R];

        String s = new In(args[1]).readAll();
        int N = s.length();
        for (int i = 0; i < N; i++)
            if (alpha.contains(s.charAt(i)))
                count[alpha.toIndex(s.charAt(i))]++;

        for (int c = 0; c < R; c++)
            StdOut.println(alpha.toChar(c)
                        + " " + count[c]);
    }
}
