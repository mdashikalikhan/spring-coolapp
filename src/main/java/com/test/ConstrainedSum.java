package com.test;

import java.util.PriorityQueue;

public class ConstrainedSum {
    public static void main(String[] args) {
        int[] nums = {10,2,-10,5,20};
        int k = 2;
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a,b)->b[0]-a[0]
        );

        int maxSum = nums[0];

        int sum_so_far = nums[0];

        heap.add(new int[]{nums[0],0});

        for(int i=1; i<nums.length; i++){
            while(heap.peek()!=null && i-heap.peek()[1]>k){
                heap.poll();
            }

            sum_so_far = heap.peek()!=null ? heap.peek()[0] : 0;

            sum_so_far = Math.max(sum_so_far+nums[i], nums[i]);

            if(sum_so_far>maxSum){
                maxSum = sum_so_far;
            }
            heap.add(new int[]{sum_so_far, i});


        }

        System.out.println(maxSum);

        /*PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> b-a
        );
        pq.add(10);
        pq.add(9);
        pq.add(90);
        pq.add(81);
        pq.add(1);
        System.out.println(pq.peek());*/

    }
}
