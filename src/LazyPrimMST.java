import edu.princeton.cs.algs4.MSD;
import edu.princeton.cs.algs4.MinPQ;

/**
 * Created by pshen on 2017/7/15.
 */
public class LazyPrimMST
{
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G)
    {
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();

        visit(G, 0);
        while (!pq.isEmpty())
        {
            Edge e = pq.delMin();

            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if (marked[v]) visit(G, w);
            if (marked[w]) visit(G, v);
        }
    }

    public void visit(EdgeWeightedGraph G, int v)
    {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);
    }

    public Iterable<Edge> edges()
    { return mst; }
    public double weight()
    {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
}
