import edu.princeton.cs.algs4.In;

/**
 * Created by pshen on 2017/7/17.
 */
public class EdgeWeightDFO
{
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public EdgeWeightDFO(EdgeWeightDigraph G)
    {
        marked = new boolean[G.V()];
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();

        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    public void dfs(EdgeWeightDigraph G, int v)
    {
        marked[v] = true;
        pre.enqueue(v);
        for (DirectedEdge e : G.adj(v))
        {
            if (!marked[e.to()])
                dfs(G, e.to());
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Stack<Integer> reversePost()
    { return reversePost; }
}
