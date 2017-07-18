import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/18.
 */
public class CPM
{
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int N = in.readInt();
        EdgeWeightDigraph G = new EdgeWeightDigraph(2*N + 2);
        int s = 2 * N, t = 2 * N + 1;

        for (int i = 0; i < N; i++)
        {
            double d = in.readDouble();
            G.addEdge(new DirectedEdge(s, i, 0.0));
            G.addEdge(new DirectedEdge(i+N, t, 0.0));
            G.addEdge(new DirectedEdge(i, i + N, d));

            int m = in.readInt();
            for (int j = 0; j < m; j++) {
                int p = in.readInt();
                G.addEdge(new DirectedEdge(i+N, p, 0.0));
            }
        }

        AcyclicLP lp = new AcyclicLP(G, s);

        StdOut.println("Start times");
        for (int i = 0; i < N; i++)
            StdOut.printf("%4d: %5.1f\n", i, lp.distTo(i));
        StdOut.printf("Finish time: %5.1f\n", lp.distTo(t));
    }
}
