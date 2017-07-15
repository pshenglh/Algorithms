import edu.princeton.cs.algs4.In;

/**
 * Created by pshen on 2017/7/15.
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Edge>();
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            Edge e = new Edge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(e);
        }
    }

    public void addEdge(Edge e)
    {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v)
    { return adj[v]; }
    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<Edge>();
        for (int i = 0; i < V; i++)
            for (Edge e : adj(i))
                if (e.other(i) > i) b.add(e);
        return b;
    }
}
