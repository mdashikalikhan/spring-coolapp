package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class MiscellaneousTest {
    public static void main(String[] args) {

        /*IntStream.range(0,n).forEach(
                i-> {
                    int j=i;
                    System.out.println(i);
                }
        );*/

        /*int n = 6;

        int[] leftChild = {1,2,0,4,-1,-1};

        int[] rightChild = {-1,-1,-1,5,-1,-1};*/

        int n = 4;

        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,-1,-1,-1};

        System.out.println(validateBinaryTreeNodes(n,leftChild,rightChild));
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        Set<Integer> setNoParent = new HashSet<>();

        Set<Integer> values = new HashSet<>();

        Set<Integer> nodes = new HashSet<>();

        for(int i=0; i<n; i++){
            if(leftChild[i]!=-1 || rightChild[i]!=-1){
                setNoParent.add(i);

            }
        }

        //System.out.println(0+ "  " + setNoParent);

        for(int i=0; i<n; i++)
        {

            if(leftChild[i]!=-1){
                nodes.add(i);
                nodes.add(leftChild[i]);
                if(!values.add(leftChild[i])){
                    //System.out.println(1);
                    return false;
                }

                if(leftChild[leftChild[i]] == i || rightChild[leftChild[i]] == i){
                    //System.out.println(2);
                    return false;
                }

                setNoParent.remove(leftChild[i]);
            }

            if(rightChild[i]!=-1){
                nodes.add(rightChild[i]);
                if(!values.add(rightChild[i])){
                    //System.out.println(3);
                    return false;
                }

                if(leftChild[rightChild[i]] == i || rightChild[rightChild[i]]==i){
                    //System.out.println(4);
                    return false;
                }

                setNoParent.remove(rightChild[i]);
            }

            if(setNoParent.size()==0 && n>1){
                return false;
            }

        }


        if(setNoParent.size()!=1 && n>1){
            //System.out.println(5+ "  " + setNoParent);
            return false;
        }

        if(setNoParent.size()==1){
            int root = setNoParent.stream().findFirst().get();

            removeNode(root,leftChild,rightChild, nodes);


            if(nodes.size()!=0){
                return false;
            }
        }


        return true;
    }
    static void removeNode(int root, int[] leftChild, int[] rightChild, Set<Integer> nodes){
        nodes.remove(root);
        if(leftChild[root]==-1 && rightChild[root]==-1){
            return;
        }

        int left = leftChild[root];
        if(left!=-1){
            removeNode(left, leftChild, rightChild, nodes);
        }

        int right = rightChild[root];
        if(right!=-1){
            removeNode(right, leftChild, rightChild, nodes);
        }
    }

}
