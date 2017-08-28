package com.csh.leetcode.c0011;

/**
 * Created by jamescsh on 8/27/17.
 */
public class ContainerWithMostWater {
/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 */
    /*
    Time complexity: O(n^2)
     */
    public int maxArea(int[] height) {
        int len = height.length;
        int area = 0;
        int areaTem = 0;
        for (int i = 0; i < len - 1; i ++) {
            for (int j = i + 1; j < len; j ++) {
                areaTem = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
                area = areaTem > area ? areaTem : area;
            }
        }
        return area;
    }

    /*
    Time complexity: O(logn)
    two pointer
     */
    public int maxArea2(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int area = 0;
        int areaTem = 0;
        int aWight = 0;
        int aHeight = 0;
        while (left < right) {
            aWight = right - left;
            aHeight = height[left] > height[right] ? height[right--] : height[left++];
            areaTem = aWight * aHeight;
            area = areaTem > area ? areaTem : area;
        }
        return area;
    }

    public int maxArea3(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int area = 0;
        int areaTem = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                areaTem = (right - left) * height[right --];
            } else {
                areaTem = (right - left) * height[left ++];
            }
            area = areaTem > area ? areaTem : area;
        }
        return area;
    }


    public static void main(String[] args) {
        int[] b = new int[15000];
        for (int i=0; i<b.length; i++) {
            b[i] = i;
        }
        ContainerWithMostWater c = new ContainerWithMostWater();
        long begin = System.currentTimeMillis();
        System.out.println(c.maxArea2(b));
        System.out.println(System.currentTimeMillis() - begin);
    }

}
