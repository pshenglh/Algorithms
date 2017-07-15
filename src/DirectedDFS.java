import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/15.
 */
public class DirectedDFS
{
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s)
    {
        marked = new boolean[G.V()];
        dfg(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> source)
    {
        marked = new boolean[G.V()];
        for (int s : source)
            if (!marked[s]) dfg(G, s);
    }

    public void dfg(Digraph G, int v)
    {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfg(G, w);
    }

    public boolean marked(int v)
    { return marked[v]; }

    public static void main(String[] args)
    {
        Digraph G = new Digraph(new In(args[0]));

        Bag<Integer> sources = new Bag<Integer>();
        for (int i = 1; i < args.length; i++)
            sources.add(Integer.parseInt(args[i]));

        DirectedDFS reachable = new DirectedDFS(G, sources);

        for (int v = 0; v < G.V(); v++)
            if (reachable.marked(v)) StdOut.print(v + " ");
        StdOut.println();
    }
}
