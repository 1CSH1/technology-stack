package com.csh.leetcode.c0004;

/**
 * Created by jamescsh on 8/19/17.
 */
public class MedianofTwoSortedArrays {
/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

 */
    /*
    思路： 数组 nums1, nums2 一起根据最小的那个数组的长度来做二分法
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if ((length1 + length2) % 2 == 0) {
            return (getMidValue(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2) +
                    getMidValue(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2 + 1)) / 2;
        } else {
            return getMidValue(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2 + 1);
        }
    }

    public double getMidValue(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int size) {
        int n1 = end1 - start1;
        int n2 = end2 - start2;
        // nums1 数量小
        if (n1 > n2) {
            return getMidValue(nums2, start2, end2, nums1, start1, end1, size);
        }

        // 数量小的数组 nums1 已经没有了，则返回数量大的数组 nums2 的中间值
        if (n1 == 0) {
            return nums2[start2 + size - 1];
        }

        if (size == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        // 每次取最小数组 nums1 的一半
        int p1 = Math.min(size / 2, n1);
        int p2 = size - p1;
        int num1 = nums1[start1 + p1 - 1];
        int num2 = nums2[start2 + p2 - 1];
        if (num1 > num2) {
            return getMidValue(nums1, start1, end1, nums2, start2 + p2, end2, size - p2);
        } else if (num1 < num2) {
            return getMidValue(nums1, start1 + p1, end1, nums2, start2, end2, size - p1);
        } else {
            return num1;
        }
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays a = new MedianofTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(a.findMedianSortedArrays(nums1, nums2));
    }
}
