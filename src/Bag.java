import java.util.Iterator;

/**
 * Created by pshen on 2017/7/13.
 */
public class Bag<Item> implements Iterable<Item> {
    private int N;
    private Node first;

    private class Node
    {
        Item item;
        Node next;
    }

    public void add(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Iterator<Item> iterator()
    { return new ListIterator(); }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        { return current != null; }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
