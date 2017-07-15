import edu.princeton.cs.algs4.In;

/**
 * Created by pshen on 2017/7/15.
 */
public class SymbolDigraph
{
    private BST<String, Integer> st;
    private String[] keys;
    private Digraph G;

    public SymbolDigraph(String source, String sp)
    {
        In in = new In(source);
        st = new BST<String, Integer>();
        while (in.hasNextLine())
        {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++)
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
        }

        keys = new String[st.size()];
        for (String name : st.keys())
            keys[st.get(name)] = name;

        in = new In(source);
        G = new Digraph(st.size());
        while (in.hasNextLine())
        {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++)
                G.addEdge(v, st.get(a[i]));
        }
    }

    public String name(int v)
    { return keys[v]; }
    public Digraph G()
    { return G; }
}
