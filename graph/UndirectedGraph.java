package graph;

import java.util.ArrayList;
import java.util.List;

//Adjacency lists representation
public class UndirectedGraph {
    private List<Integer>[] adj;

    //Constructs a new graph with V vertices
    public UndirectedGraph(int V) {
        adj = (List<Integer>[]) new List[V];
        for(int i=0; i<V; ++i){
            adj[i] = new ArrayList<>();
        }
    }

    //Adds an edge from v1 to v2 and from v2 to v1

    public void addEdge(int v1, int v2){

        adj[v1].add(v2);
        adj[v2].add(v1);
    }

    //return v's adjacency list
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
