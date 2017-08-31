package com.csh.leetcode.c0014;

/**
 * Created by jamescsh on 8/30/17.
 */
public class LongestCommonPrefix {
/*
Write a function to find the longest common prefix string amongst an array of strings.
 */
    /*
    Time complexity: O(m*n)
    Space complexity: O(n)
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (0 == len) {
            return "";
        } else if (1 == len) {
            return strs[0];
        }
        int i = 0;
        char tem = '0';
        boolean isKeep = true;
        while (isKeep) {
            if (i < strs[0].length()) {
                tem = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || tem != strs[j].charAt(i)) {
                        isKeep = false;
                        break;
                    }
                }
            } else {
                isKeep = false;
            }
            i ++;
        }
        return strs[0].substring(0, i - 1);
    }

    /*
    把第一个字符串ret当作结果，如果匹配不成功，则把ret从后面截掉1个字符
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String ret = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            while (strs[i].indexOf(ret) != 0) {
                ret = ret.substring(0, ret.length() - 1);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"acc", "aaaa", "aa"};
        System.out.println(lcp.longestCommonPrefix(strs));
        "".substring(0, 0);
    }

}
