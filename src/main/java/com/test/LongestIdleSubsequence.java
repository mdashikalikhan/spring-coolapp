package com.test;

import java.util.*;

public class LongestIdleSubsequence {
    public static void main(String[] args) {
        String s = "acfgbd";//""eduktdb";
        int k = 2;//15;
        int[] dp = new int[s.length()];

        Arrays.fill(dp,1);

        Map<Character, Integer> lastPosition = new HashMap<>();

        lastPosition.put(s.charAt(0), 0);

        int max = 1;

        for(int i=1; i< s.length(); i++){
            //System.out.println((char)(s.charAt(i)+2)<'z');
            System.out.println(lastPosition);
            System.out.println(s.charAt(i) + " working...");
            if(lastPosition.get(s.charAt(i))!=null){
                int pos = lastPosition.get(s.charAt(i));
                dp[i] = Math.max(dp[i], dp[pos]+1);
            }
            for(int j=1; j<=k; j++){
                if((char)(s.charAt(i)+j)<='z'){
                    //System.out.print((char)(s.charAt(i)+j) + " ");
                    char c = (char)(s.charAt(i)+j);
                    if(lastPosition.get(c)!=null){

                        int pos = lastPosition.get(c);

                        dp[i] = Math.max(dp[i], dp[pos] + 1);

                        System.out.println(c+ " " + pos + " " + dp[pos] + " " + dp[i]);

                    }
                }

                if((char)(s.charAt(i)-j)>='a'){
                    //System.out.print((char)(s.charAt(i)-j) + " ");
                    char c = (char)(s.charAt(i)-j);
                    if(lastPosition.get(c)!=null){
                        int pos = lastPosition.get(c);
                        dp[i] = Math.max(dp[i], dp[pos] + 1);
                        System.out.println(c+ " " + pos + " " + dp[pos] + " " + dp[i]);

                    }
                }
            }
            lastPosition.put(s.charAt(i), i);

            if(max<dp[i]){
                max = dp[i];
            }

        }



        System.out.println(max);
        /*for(int val: dp){
            System.out.println(val);
        }*/
    }
}
