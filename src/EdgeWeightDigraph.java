import edu.princeton.cs.algs4.In;

/**
 * Created by pshen on 2017/7/16.
 */
public class EdgeWeightDigraph
{
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightDigraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }

    public EdgeWeightDigraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();

            DirectedEdge e = new DirectedEdge(v, w, weight);
            addEdge(e);
        }
    }

    public void addEdge(DirectedEdge e)
    {
        int v = e.from();
        adj[v].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v)
    { return adj[v]; }

    public Iterable<DirectedEdge> edges()
    {
        Bag<DirectedEdge> edges = new Bag<>();
        for (int v = 0; v < V; v++)
            for (DirectedEdge e : adj(v))
                edges.add(e);
        return edges;
    }


    public int V()
    { return V; }
}
