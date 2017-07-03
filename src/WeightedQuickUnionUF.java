import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/3.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }
    public int count()
    { return count; }
    public boolean connected(int p, int q)
    {return find(p) == find(q); }
    public int find(int p)
    {
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i];}
        else { id[j] = i; sz[i] += sz[j]; }
        count--;
    }
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int N = in.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!in.isEmpty())
        {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
    }
}
