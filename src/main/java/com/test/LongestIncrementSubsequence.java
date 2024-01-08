package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncrementSubsequence {

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};//{0,1,0,3,2,3};//{10,9,2,5,3,7,101,18};

        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            if(list.size()==0 || list.get(list.size()-1)<num){
                list.add(num);
            } else if(list.get(0)>num){
                list.set(0, num);
            } else{
                int lower = 0;
                int upper = list.size()-1;
                while(lower<upper){
                    int mid = lower + (upper-lower)/2;
                    int element = list.get(mid);
                    if(element==num){
                        break;
                    }

                    if(element<num){
                        if(mid+1<=list.size()-1 && list.get(mid+1)>num){
                            list.set(mid+1, num);
                            break;
                        }
                        lower = mid + 1;
                    } else{
                        if(mid-1>=0 && list.get(mid-1)<num){
                            list.set(mid, num);
                            break;
                        }
                        upper = mid - 1;
                    }
                }
            }
        }

        System.out.println(list);

    }
}
