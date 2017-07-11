/**
 * Created by pshen on 2017/7/10.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N;

    private class Node
    {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key)
    {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key, Value val)
    {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
            { x.val = val; return; }
        first = new Node(key, val, first);
        N++;
    }

    public int size()
    { return N; }

    public Iterable<Key> keys()
    {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

   private Node delete(Node x, Key key)
   {
       if (x == null) return null;
       if (key.equals(x.key))
       {
           N--;
           return x.next;
       }
       x.next = delete(x.next, key);
       return x;
   }

   public void delete(Key key)
   {
       if (key == null) return;
       first = delete(first, key);
   }
}
