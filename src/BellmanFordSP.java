
/**
 * Created by pshen on 2017/7/18.
 */
public class BellmanFordSP
{
    private boolean[] onQ;
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private int count;
    private Queue<Integer> queue;
    private Iterable<Integer> cycle;

    public BellmanFordSP(EdgeWeightDigraph G, int s)
    {
        distTo = new double[G.V()];
        onQ = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        queue = new Queue<>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;]
        while (!queue.isEmpty() && !hasNegativeCycle())
        {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }

    public void relax(EdgeWeightDigraph G, int v)
    {
        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w])
                {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (count++ % G.V() == 0)
                findNegativeCycle();
        }
    }

    public boolean hasNegativeCycle()
    { return cycle != null; }

    public void findNegativeCycle()
    {
        int V = edgeTo.length;
        EdgeWeightDigraph G = new EdgeWeightDigraph(V);
        for (int v = 0; v < V; v++)
            if (edgeTo[v] != null)
                G.addEdge(edgeTo[v]);

        EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(G);
        cycle = cf.cycle();
    }

    public Iterable<Integer> negativeCycle()
    { return cycle; }
}
