package graph;

/* import ArrayList.List;

import java.util.*;

public class GraphMap {
    private Map<Integer, List<Integer>> adjVertices;

    public GraphMap(){
        this.adjVertices = new HashMap<Integer, List<Integer>>();
    }

    public void addVertex(int vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
        adjVertices.get(src).add(dest);
    }

    public  void dfsWithoutRecursion(int start){
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] isVisited = new boolean[adjVertices.size()];
        stack.push(start);
        while(!stack.isEmpty()){
            int current = stack.pop();
            isVisited[current] = true;
            visit(current);
            for(int dest: adjVertices.get(current)){
                if(!isVisited[dest]){
                    stack.push(dest);
                }
            }
        }
    }

    public void dfs(int start) {
        boolean[] isVisited = new boolean[adjVertices.size()];
        dfsRecursive(start, isVisited);
    }

    private void dfsRecursive(int current, boolean[] isVisited) {
        isVisited[current] = true;
        visit(current);
        for(int dest: adjVertices.get(current)){
            if(!isVisited[dest])
                dfsRecursive(dest, isVisited);
        }
    }

    public LinkedList<Integer> topologicalSort(int start){
        LinkedList<Integer> result = new LinkedList<Integer>();
        boolean[] isVisited = new boolean[adjVertices.size()];
        topologicalSortRecursive(start, isVisited,result);
        return result;
    }

    private void topologicalSortRecursive(int current, boolean[] isVisited, LinkedList<Integer> result) {
       isVisited[current] = true;
       for(int dest: adjVertices.get(current)){
           if(!isVisited[dest]){
                topologicalSortRecursive(dest, isVisited, result);
           }
       }
       result.addFirst(current);
    }


    private void visit(int value) {
        System.out.println(" " + value);
    }
}

 */
