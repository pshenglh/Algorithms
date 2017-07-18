import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/18.
 */
public class AcyclicLP
{
    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public AcyclicLP(EdgeWeightDigraph G, int s)
    {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.NEGATIVE_INFINITY;
        distTo[s] = 0.0;

        EdgeWeightedTopological top = new EdgeWeightedTopological(G);
        for (int v : top.order())
            relax(G, v);
    }

    public void relax(EdgeWeightDigraph G, int v)
    {
        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (distTo[w] < distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v)
    { return distTo[v]; }
}
