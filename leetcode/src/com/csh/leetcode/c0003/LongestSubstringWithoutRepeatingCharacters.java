package com.csh.leetcode.c0003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jamescsh on 8/17/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

    /*
    Time complexity: O(n^3)
    Space complexity: O(min(n, m))  n: s.length   m: size of set
    2个循环中检查 [i, j) 之间是不是存在相同的字符（检查是不是有相同的字符需要1个循环），不存在则 j - i，跟先前的最长长度对比，取之间最大的
     */
    public int lengthOfLongestSubstring1(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i ++) {
            for (int j = i + 1; j <= s.length(); j ++) {
                if (allUnique(s, i, j)) {
                    longest = Math.max(longest, j - i);
                }
            }
        }
        return longest;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    /*
    Time complexity: O(n^2)
    Space complexity: O(min(n, m))
    将上面的解法中的检查是不是有相同的字符的那个循环改为 O(1) 的 Set，用一个窗口来表示最长不重复字符长度
     */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int longest = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                longest = Math.max(longest, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return longest;
    }

    /*
    Time complexity: O(n)
     */
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        for (int i = 0, j = 0; j < s.length(); j ++) {
            // 如果出现重复字符串，则获取重复字符串上一次出现的位置和现在的 i 的大小，将最大值赋值给 i
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            // 计算得到最长的不重复字符串长度
            longest = Math.max(longest, j - i + 1);
            // 将字符串以及位置放到Map中
            map.put(s.charAt(j), j + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(a.lengthOfLongestSubstring3("abcabcbb")); // 3
        System.out.println(a.lengthOfLongestSubstring1("bbbbb"));  // 1
        System.out.println(a.lengthOfLongestSubstring1("pwwkew"));  // 3
    }

}
