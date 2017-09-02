package com.csh.leetcode.c0015;

import java.util.*;

/**
 * Created by jamescsh on 8/31/17.
 */
public class C_3Sum {
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
    /*
    Time complexity: O(n^2)
    Space complexity: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums, 0);
    }

    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        List<List<Integer>> rets = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return rets;
        }

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++) {
            // 去除重复的
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = nums[left] + nums[right];
                int curTarget = target - nums[i];
                if (curSum > curTarget) {
                    right --;
                } else if (curSum < curTarget) {
                    left ++;
                } else {
                    List<Integer> ret = new ArrayList<Integer>();
                    ret.add(nums[left]);
                    ret.add(nums[i]);
                    ret.add(nums[right]);
                    rets.add(ret);
                    left ++;
                    right --;
                    // 除去重复
                    while (left < right && nums[left] == nums[left - 1]) {
                        left ++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right --;
                    }
                }
            }

        }
        return rets;
    }

    public static void main(String[] args) {
        C_3Sum sum = new C_3Sum();
        int[] nums = {1,2,3};
        sum.threeSum(nums);
    }
}
