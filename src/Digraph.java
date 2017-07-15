import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/15.
 */
public class Digraph
{
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int v)
    {
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Integer>();
    }

    public Digraph(In in)
    {
        this(in.readInt());
        this.E = in.readInt();
        for (int i = 0; i < E; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v)
    { return adj(v); }

    public Digraph reverse()
    {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                R.addEdge(w, v);
        return R;
    }

    public String toString()
    {
        String s = " ";
        for (int i = 0; i < V; i++)
        {
            s += i + ": ";
            for (int w : adj(i))
                s += w + " ";
            StdOut.println();
        }
        return s;
    }
}
