/**
 * Created by pshen on 2017/7/17.
 */
public class EdgeWeightedTopological
{
    private Iterable<Integer> order;

    public EdgeWeightedTopological(EdgeWeightDigraph G)
    {
        EdgeWeightedCycleFinder cycle = new EdgeWeightedCycleFinder(G);
        if (!cycle.hasCycle())
        {
            EdgeWeightDFO dfo = new EdgeWeightDFO(G);
            order = dfo.reversePost();
        }
    }

    public Iterable<Integer> order()
    { return order; }
}
