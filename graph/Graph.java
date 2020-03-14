package graph;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Depth First Search for a Graph
public class Graph {
    /*private int V; //Number of Vertices
    //Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    //Graph Constructor
    public Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }

    //function to add an edge into the graph
    public void addEdge(int x, int y) {
        adj[x].add(y);
    }

    //A function used by DFS
    void DFSUtil(int v, boolean visited[]){
        //Mark the current node as visited and print it
        visited[v] = true;
        System.out.println(v + " ");

        //recursive for all the vertices adjacent to this vertices
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }

    //The function to do DFS Traversal. It uses recursiive DFSUtil()
   void DFS(int v){

        //Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[V];

        //Call the recursive helper function to print DFS
       DFSUtil(v, visited);
   }


   public static void main(String args[]){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
       System.out.println("Following is Depth First Traversal, starting form vertex 2");

       g.DFS(2);
   }
     */


    private Map<Vertex, List<Vertex>> adjVertices;

    Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) { // By using 'label' to create a vertex, and use this vertex to search the every adjacency list with this vertex
        Vertex v = new Vertex(label);// and remove it
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
        }
        return sb.toString();
    }

    class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }


}




