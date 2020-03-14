package PriorityQueue;

public interface PriorityQueues<K extends Comparable<K>>{
    public void add(K x) throws Exception;
    public K removeMin() throws Exception;
}
