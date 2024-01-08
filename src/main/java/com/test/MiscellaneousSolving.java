package com.test;

import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.*;
import java.util.stream.IntStream;

public class MiscellaneousSolving {

    public static void main(String[] args) {
        MiscellaneousSolving ms = new MiscellaneousSolving();
        Integer sum=0;
        Integer count=0;

        /*ms.loop(sum, count);*/

        System.out.println(sum + " " + count);
        List<int[][]> list = new ArrayList<>();

        int h=3;
        int w = 5;
        int[][] arr = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        String s = "<       200   3";
        String[] sarr = s.split("\\s+");
        System.out.println(sarr.length);
        int r1 = Integer.valueOf( sarr[1]);
        int r2 = Integer.valueOf( sarr[2]);
        System.out.println(r1 + " " + r2);

        String t1 = "abcdef";
        System.out.println(t1.substring(3));

        int res = 5 ^ 2 ^ 7;

        System.out.println(res);

        System.out.println(res^5^2);

        System.out.println(1^2^3);

        System.out.println(2^3);

        System.out.println(1^1);

        /*TreeSet<Integer> set = new TreeSet<>(IntStream.range(1,10).boxed().toList());
        System.out.println(set);
        set.remove(10);
        set.remove(4);
        set.remove(3);
        set.remove(2);
        set.remove(1);
        int first = set.first();
        System.out.println(set.first());*/
        /*Map<Integer, List<Integer>> map = new HashMap<>();

        map.put(1, Arrays.asList(2,3,4,5));*/

        /*int[][] arr2d = new int[10][20];

        Arrays.fill(arr2d, 1);

        System.out.println(arr2d[5][1]);*/

        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(10,9,200,100));
        System.out.println(pq);

        /*int dist[] = {3,2,4}, speed[] = {5,3,2};

        for(int i=0; i<dist.length; i++){
            dist[i]/=speed[i];
        }

        pq = new PriorityQueue<>(Arrays.stream(dist).boxed().toList());
        System.out.println(pq.poll());
        int num1 = 6;
        int num2 = 3;

        num1 = (int) Math.ceil( (double)num1/num2);

        System.out.println(num1);

        System.out.println(0%3);*/

        /*int mod = 1000000007;

        System.out.println(mod);*/

        /*Set<Integer> set = new HashSet<>();
        set.stream().mapToInt(Integer::intValue).toArray();
        List<Integer> list = new ArrayList<>();
        list.stream().mapToInt(Integer::intValue).toArray();*/
        TreeSet<Integer> tset = new TreeSet<>();
        tset.add(100);
    }
    void loop(Integer sum, Integer count){
        if(count>=10){
            sum += count;
        }
        loop(sum+count, ++count);
    }
}
