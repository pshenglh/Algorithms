
/**
 * Created by pshen on 2017/7/17.
 */
public class EdgeWeightedCycleFinder
{
    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public EdgeWeightedCycleFinder(EdgeWeightDigraph G)
    {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++)
        {
            if (!marked[v]) dfs(G, v);
        }
    }

    public void dfs(EdgeWeightDigraph G, int v)
    {
        marked[v] = true;
        onStack[v] = true;
        for (DirectedEdge e : G.adj(v))
        {
            if (hasCycle()) return;
            int w = e.to();
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w])
            {
                for (int i = v; v != w; v = edgeTo[v])
                    cycle.push(i);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle()
    { return cycle != null; }

    public Iterable<Integer> cycle()
    { return cycle; }
}
