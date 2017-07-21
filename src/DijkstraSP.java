import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Created by pshen on 2017/7/17.
 */
public class DijkstraSP
{
    private DirectedEdge[] edgeTo;
    private Double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightDigraph G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new Double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty())
            relax(G, pq.delMin());
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
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo(int v)
    { return distTo[v]; }
    public boolean hasPathTo(int v)
    { return distTo[v] < Double.POSITIVE_INFINITY; }
    public Iterable<DirectedEdge> pathTo(int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
        for (int i = v; distTo[i] != 0.0; i = edgeTo[i].from())
            stack.push(edgeTo[i]);
        return stack;
    }
}