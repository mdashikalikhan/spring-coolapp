package com.test;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        WordLadder2 word2 = new WordLadder2();
        /*String beginWord = "hit";
        String endWord ="cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");*/
        String beginWord = "red";
        String endWord ="tax";
        List<String> wordList = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        List<List<String>> result = word2.findLadders(beginWord,endWord,wordList);
        System.out.println(result);
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return ans;
        }

        Map<Integer, List<String>> mapLength = new HashMap<>();

        Map<String, List<List<String>>> mapLastWord = new HashMap<>();

        for(String str : wordList){
            List<String> t = mapLength.getOrDefault(str.length(), new ArrayList<String>());
            t.add(str);
            mapLength.put(str.length(), t);
        }

        Queue<String> queue = new LinkedList<>();
        Set<List<String>> visited = new HashSet<>();
        Set<List<String>> ansVisited = new HashSet<>();

        queue.add(beginWord);
        mapLastWord.put(beginWord, Arrays.asList(Arrays.asList(beginWord)));

        //int count = 1;

        visited.add(Arrays.asList(beginWord));

        int isFound = 0;
        while(!queue.isEmpty() && isFound==0){
            int size = queue.size();
            while(size>0 ){
                size--;
                String str = queue.poll();

                List<String> neighbours = mapLength.getOrDefault(str.length(),
                        new ArrayList());

                /*System.out.println(neighbours);
                System.out.println(mapLastWord);*/


                for(String neighbour : neighbours){
                    if(isEligibleNeighbour(str,neighbour)){
                        if(neighbour.equals(endWord)){
                            List<List<String>> t = new ArrayList<>(
                                    mapLastWord.getOrDefault(str,
                                            Arrays.asList(
                                            new ArrayList<String>())));

                            for(List<String> l : t){
                                List<String> l1 = new ArrayList<>(l);
                                l1.add(endWord);
                                if(ansVisited.add(l1)){
                                    ans.add(l1);
                                }

                            }

                            isFound = 1;

                        } else{
                                List<List<String>> t = new ArrayList<>(
                                        mapLastWord.getOrDefault(str, Arrays.asList(
                                                new ArrayList<String>())));

                                int addQueue = 0;
                                for(List<String> ll : t){
                                    List<String> l = new ArrayList<>(ll);
                                    l.add(neighbour);
                                    if(!visited.contains(l)){
                                        if(mapLastWord.get(neighbour)==null){
                                            mapLastWord.put(neighbour, Arrays.asList(l));
                                            addQueue = 1;
                                        } else{
                                            if(mapLastWord.get(neighbour).get(0).size()
                                                    ==l.size()){
                                                List<List<String>> l1 =
                                                        new ArrayList<>(mapLastWord.get(neighbour));
                                                l1.add(l);
                                                mapLastWord.put(neighbour, l1);
                                                addQueue = 1;
                                            }

                                        }
                                        visited.add(l);

                                    }
                                }
                                if(addQueue==1){
                                    queue.add(neighbour);
                                }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public boolean isEligibleNeighbour(String str, String neighbour){
        if(str.length()!=neighbour.length()){
            return false;
        }

        int count = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=neighbour.charAt(i)){
                count++;
            }
            if(count>1){
                return false;
            }
        }

        return count==1;

    }
}
