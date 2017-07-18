import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/17.
 */
public class AcyclicSP
{
    private DirectedEdge[] edgeTo;
    private Double[] distTo;

    public AcyclicSP(EdgeWeightDigraph G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new Double[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
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
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v)
    {
        return distTo[v];
    }
    public boolean hasPathTo(int v)
    { return distTo[v] < Double.POSITIVE_INFINITY; }

    public Stack<DirectedEdge> pathTo(int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }

    public static void main(String[] args)
    {
        EdgeWeightDigraph G = new EdgeWeightDigraph(new In(args[0]));
        int s = Integer.parseInt((args[1]));
        AcyclicSP sp = new AcyclicSP(G, s);

        for (int i = 0; i < G.V(); i++)
        {
            StdOut.print(s + " to " + i);
            StdOut.printf(" (%4.2f): ", sp.distTo(i));
            if (sp.hasPathTo(i))
                for (DirectedEdge e : sp.pathTo(i))
                    StdOut.print(e + " ");
            StdOut.println();
        }

    }
}
