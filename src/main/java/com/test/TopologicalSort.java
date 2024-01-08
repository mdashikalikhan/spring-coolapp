package com.test;

import java.util.*;

public class TopologicalSort {

    // no of vertices
    private int V;
    private Map<Integer, List<Integer>> graph;

    public TopologicalSort(int v) {
        V = v;

        graph = new HashMap<>();

        for (int i=0; i<v; i++){
            graph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int from, int to){
        graph.get(from).add(to);
    }


    //perform topological sort
    public void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i=0; i<V; i++){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }
        System.out.println("Topological Order");

        while (!stack.empty()){
            System.out.println(stack.pop() +" ");
        }
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {

        visited[v] = true;

        for(int neighbor : graph.get(v)){
            if(!visited[neighbor]){
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        stack.push(v);

    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(5);

        /*graph.addEdge(5,2);
        graph.addEdge(5,0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);*/

        /*graph.addEdge(1,5);
        graph.addEdge(2,5);
        graph.addEdge(3,5);
        graph.addEdge(3,4);
        graph.addEdge(4,5);*/

        graph.addEdge(0,4);
        graph.addEdge(3,4);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(1,2);

        System.out.println(graph);

        graph.topologicalSort();

    }

    @Override
    public String toString() {
        return "TopologicalSort{" +
                "V=" + V +
                ", graph=" + graph +
                '}';
    }
}
