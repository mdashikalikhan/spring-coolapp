package com.test;

public class BeautifulArray {

    public static void main(String[] args) {
        int k = 4;
        int nums[]={2,3,0,0,2};
        BeautifulArray arr = new BeautifulArray();
        System.out.println(arr.minIncrementOperations(nums, k));
    }
    public long minIncrementOperations(int[] nums, int k) {
        //Arrays.sort(nums);
        /*int len = nums.length ;
        long operations = 0;

        for(int i=0; i<=len-3; i++){
            if(nums[i]>=nums[i+1] && nums[i]>=nums[i+2]){
                if(nums[i]<k){
                    operations += k-nums[i];
                    nums[i] = k;
                }
            }else if(nums[i+1]>=nums[i] && nums[i+1]>=nums[i+2]){
                if(nums[i+1]<k){
                    operations += k-nums[i+1];
                    nums[i+1] = k;
                }
            }else if(nums[i+2]>=nums[i] && nums[i+2]>=nums[i+1]){
                if(nums[i+2]<k){
                    operations += k-nums[i+2];
                    nums[i+2] = k;
                }
            }

        }*/
        long dp1=0, dp2=0,dp3=0;
        for(int a: nums){
            long dp = Math.min(Math.min(dp1, dp2),dp3)+ Math.max(k-a,0);
            dp1=dp2;
            dp2=dp3;
            dp3=dp;

            System.out.println(a + " = " + dp1 + " " + dp2 + " " + dp3);
        }
        return Math.min(Math.max(dp1, dp2),dp3);
    }
}
