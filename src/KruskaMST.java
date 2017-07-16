import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/16.
 */
public class KruskaMST
{
    private Queue<Edge> mst;

    public KruskaMST(EdgeWeightedGraph G)
    {
        MinPQ<Edge> pq = new MinPQ<>();
        mst = new Queue<Edge>();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
        for (Edge e : G.edges()) pq.insert(e);

        while (!pq.isEmpty())
        {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges()
    { return mst; }
    public double weight()
    {
        Double weight = 0.0;
        for (Edge e : mst)
            weight += e.weight();
        return weight;
    }

    public static void main(String[] args)
    {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskaMST mst = new KruskaMST(G);
        for (Edge e : mst.mst)
            StdOut.println(e);
        StdOut.println(mst.weight());
    }
}
