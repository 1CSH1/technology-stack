package com.csh.leetcode.c0016;

import java.util.Arrays;

/**
 * Created by jamescsh on 9/2/17.
 */
public class C_3SumClosest {
/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        // 排序
        Arrays.sort(nums);

        int min = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i ++) {
            int cur = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int ret = cur + nums[left] + nums[right];
                if (Math.abs(ret - target) < Math.abs(min - target)) {
                    min = ret;
                }
                if (target > ret) {
                    left ++;
                } else if (target < ret) {
                    right --;
                } else {
                    return ret;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        C_3SumClosest closest = new C_3SumClosest();
        System.out.println(closest.threeSumClosest(null, 4));
    }
}
