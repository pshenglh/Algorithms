import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pshen on 2017/7/14.
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    public void bfs(Graph G, int s)
    {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();
            for (int w : G.adj(v))
                if (!marked[w])
                {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
        }
    }

    public boolean hasToPath(int v)
    { return marked[v]; }

    private Iterable<Integer> pathTo(int v)
    {
        if (!hasToPath(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int i = v; i != s; i = edgeTo[i])
            path.push(i);
        path.push(s);
        return path;
    }

    public static void main(String[] args)
    {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths search = new BreadthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++)
        {
            StdOut.print(s + " to " + v + ": ");
            if (search.hasToPath(v))
            {
                for (int x : search.pathTo(v))
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            }
            StdOut.println();
        }
    }
}
