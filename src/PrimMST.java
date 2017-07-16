import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Created by pshen on 2017/7/16.
 */
public class PrimMST
{
    private boolean[] marked;
    private double[] distTo;
    private IndexMinPQ pq;
    private Edge edgeTo[];

    public PrimMST(EdgeWeightedGraph G)
    {
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < G.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        pq = new IndexMinPQ<Double>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty())
            visit(G, pq.delMin());
    }

    public void visit(EdgeWeightedGraph G, int v)
    {
        marked[v] = true;
        for (Edge e : G.adj(v))
        {
            int w = e.other(v);
            if (marked[w] continue;
            if (e.weight() < distTo[w])
            {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }
}
