import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/15.
 */
public class Topological
{
    private Iterable<Integer> order;

    public Topological(Digraph G)
    {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle())
        {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversPost();
        }
    }

    public Iterable<Integer> order()
    { return order; }
    public boolean siDAG()
    { return order != null; }

    public static void main(String args[])
    {
        String filename = args[0];
        String separator = args[1];

        SymbolDigraph sg = new SymbolDigraph(filename, separator);
        Topological top = new Topological(sg.G());

        for (int v : top.order())
            StdOut.println(sg.name(v));
    }
}
