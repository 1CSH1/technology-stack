package com.csh.leetcode.c0005;

/**
 * Created by jamescsh on 8/21/17.
 */
public class LongestPalindromicSubstring {
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 */

    /*
    思路：每一个回串符都是以一个字符或者两个字符为中心的，比如aba,abba
    遍历一次字符串，以第 i 个字符或者 i + 1 个字符为中心，求出它的最长回串符，记录它的开始和结束下标，和目前的记录的最长回文串比较，如果更长则记录
     */
    public String longestPalindrome(String s) {
        int start = 0 ;
        int end = 0;
        int len1 = 0;
        int len2 = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i ++) {
            len1 = expandAroudCenter(s, i, i);
            len2 = expandAroudCenter(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroudCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        System.out.println(s.longestPalindrome("babad"));
    }
}
