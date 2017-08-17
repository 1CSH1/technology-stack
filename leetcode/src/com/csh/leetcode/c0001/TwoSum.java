package com.csh.leetcode.c0001;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamescsh on 8/16/17.
 */
public class TwoSum {
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

    /*
    Time complexity: O(n)
    Space complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = target - nums[i];
            if (map.containsKey(result) && i < map.get(result)) {
                return new int[]{i, map.get(result)};
            }
        }

        return null;
    }

    /*
    Time complexity: O(n)
    Space complexity: O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }


    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 13};
        int target = 9;
        print(ts.twoSum(nums, target));
        print(ts.twoSum2(nums, target));
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
