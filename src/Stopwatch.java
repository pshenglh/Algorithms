/**
 * Created by pshen on 2017/7/3.
 */
public class Stopwatch {
    private final long start;
    public Stopwatch()
    { start = System.currentTimeMillis(); }
    public double elapsedTime()
    {
        long now = System.currentTimeMillis();
        return  (now - start) / 100.0;
    }
}
