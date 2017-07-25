import edu.princeton.cs.algs4.StdOut;

public class KMP
{
    private String pat;
    private int[][] dfa;
    public KMP(String pat)
    {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++)
        {
            for (int c = 65; c < 68; c++) {
                dfa[c][j] = dfa[c][X];
                StdOut.printf("dfa[%c][%d] = dfa[%c][%d] = %d", c, j, c, X, dfa[c][j]);
                StdOut.println();
            }
            dfa[pat.charAt(j)][j] = j+1;
            StdOut.printf("dfa[%c][%d] = %d", pat.charAt(j), j, j+1);
            StdOut.println();
            X = dfa[pat.charAt(j)][X];
        }
        StdOut.println("-----------------");
        for (int i = 0; i < M; i++)
            for (int c =65; c < 68; c++)
            {
                StdOut.printf("dfa[%c][%d] = %d", c, i, dfa[c][i]);
                StdOut.println();
            }

    }
    public int search(String txt)
    {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++)
        {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i - M;
        else return N;
    }

    public static void main(String[] args)
    {
        String pat = args[0];
        String txt = args[1];
        KMP kmp = new KMP(pat);
        StdOut.println("text:    " + txt);
        int offset = kmp.search(txt);
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
