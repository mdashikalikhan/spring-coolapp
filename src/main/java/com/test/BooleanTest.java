package com.test;

import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.*;

public class BooleanTest {
    public static void main(String[] args) {
        boolean x ;
        boolean y;
        System.out.println(isOk(true,false));
        System.out.println(isOk(false,true));
        System.out.println(isOk(true,true));
        System.out.println(isOk(false,false));

        String s = "12345";

        System.out.println(s.substring(0,Math.min(50, s.length())));

        System.out.println(s.substring(0,4));

        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.substring(0,4));
        sb.delete(0,4);
        System.out.println(sb.toString());

        /*Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(1,2,3,4,5));

        for(Integer i : map.get(2)){
            System.out.println(i);
        }*/

        System.out.println(1<<31);
        /*System.o
        String str="0PPo j";ut.println(1<<0);
        System.out.println(1<<1);
        System.out.println(1<<3);
        System.out.println(Integer.valueOf("0PP sdaf"));*/

        Map<String, List<String>> map = new HashMap<>();
        map.put("abc", Arrays.asList("abc", "def", "ghi"));
        /*List<String> tt = new ArrayList<>();
        tt.add("abc");
        tt.add("def");
        tt.add("ghi");
        tt.add("jkl");
        map.put("abc", tt);*/
        List<String> t = new ArrayList<>(map.getOrDefault("abc", new ArrayList<String>()));
        t.add("xyz");
        System.out.println(map.get("abc"));
        Set<List<String>> visited = new HashSet<>();
        visited.add(Arrays.asList("c,b,a"));
        if(visited.contains(Arrays.asList("a,b,c"))){
            System.out.println("visited");
        } else{
            System.out.println("not visited");
        }

        /*int a = 10;
        int b = 20;
        int c = 30;

        int first = Math.max()*/

        int[] t1 = {0,1,3};
        int[] t2 = t1.clone();

        t2[0]=5;
        System.out.println(t1[0]);

    }

    public static boolean isOk(boolean x, boolean y) {
        if(!x || y) {
            System.out.println("Not Term Loan");
            return false;
        }
        return true;
    }


}
