package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParallelCourse {

    Map<Integer, List<Integer>> graph;
    Map<Integer, Integer> nodeWeight;

    public static void main(String[] args) {
        ParallelCourse parallelCourse = new ParallelCourse();

        int n = 5;

        int[][] relations = {{1,5},{2,5},{3,5},{3,4},{4,5}};

        int[] time = {1,2,3,4,5};

        System.out.println(parallelCourse.minimumTime(n, relations, time));
    }

    public  int minimumTime(int n, int[][] relations, int[] time) {

        graph = new HashMap<>();
        nodeWeight = new HashMap<>();

        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<Integer>());
        }

        for(int i=0; i<relations.length; i++){
            graph.getOrDefault(relations[i][0], new ArrayList<Integer>()).add(relations[i][1]);
        }
        System.out.println(graph);

        int minTime = toplogicalSortWIthTime(n, time);

        /*for(int i=1; i<=n; i++){
            System.out.println(vTime[i] );
        }*/

        System.out.println(nodeWeight);

        return minTime;

    }

    public  int toplogicalSortWIthTime(int n, int[] time){
        boolean[] visited = new boolean[n+1];

        //Stack<Integer> stack = new Stack<>();
        int requiredTime = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                int timeV = toplogicalSortUtil(i, time, visited);
                requiredTime = Math.max(requiredTime, timeV);
            }
            //stack.push();

        }
        return requiredTime;

    }

    public  int toplogicalSortUtil(int v, int[] time , boolean[] visited){
        visited[v] = true;

        int neighborMaxTime = 0;

        for(int neighbor : graph.get(v)){
            if(!visited[neighbor]){
                int t = toplogicalSortUtil(neighbor, time, visited);
                System.out.println("neighbor :" + neighbor + " time: " + t);
                neighborMaxTime = Math.max(neighborMaxTime, t);
                //System.out.println(t + " " + neighborMaxTime);

            } else {
                System.out.println("neighbor :" + neighbor + " time: " + nodeWeight.getOrDefault(neighbor, 0));
                neighborMaxTime = Math.max(neighborMaxTime, nodeWeight.getOrDefault(neighbor, 0));
            }
        }

        nodeWeight.put(v, time[v-1] + neighborMaxTime);
        System.out.println("vertex: " + v + " Total Time: " + nodeWeight.get(v));
        return nodeWeight.get(v);
    }
}
