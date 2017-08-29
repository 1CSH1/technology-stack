package com.csh.leetcode.c0012;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamescsh on 8/28/17.
 */
public class IntegerToRoman {
/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

这题需要一些背景知识，首先要知道罗马数字是怎么表示的：

http://en.wikipedia.org/wiki/Roman_numerals

I: 1
V: 5
X: 10
L: 50
C: 100
D: 500
M: 1000

字母可以重复，但不超过三次，当需要超过三次时，用与下一位的组合表示：
I: 1, II: 2, III: 3, IV: 4
C: 100, CC: 200, CCC: 300, CD: 400

s = 3978
3978/1000 = 3: MMM
978>(1000-100), 998/900 = 1: CM
78<(100-10), 78/50 = 1 :L
28<(50-10), 28/10 = XX
8<(100-1), 8/5 = 1: V
3<(5-1), 3/1 = 3: III
ret = MMMCMLXXVIII

所以可以将单个罗马字符扩展成组合形式，来避免需要额外处理类似IX这种特殊情况。
I: 1
IV: 4
V: 5
IX: 9
X: 10
XL: 40
L: 50
XC: 90
C: 100
CD: 400
D: 500
CM: 900
M: 1000
 */
    /*
    Time complexity: O(n)
    Space complexity: O(26)
     */
    public String intToRoman(int num) {
        int[] roman = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        String ret = "";
        int i = 0;
        int temp = 0;
        while (i < roman.length) {
            temp = num / roman[i];
            if (temp != 0) {
                while (temp > 0) {
                    ret += map.get(roman[i]);
                    temp --;
                }
                num %= roman[i];
            }
            i ++;
        }
        return ret;
    }

    public String intToRoman2(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String ret = "";
        for (int i = 0; num != 0; i ++) {
            while (num >= nums[i]) {
                num -= nums[i];
                ret += roman[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        System.out.println(itr.intToRoman(3978));
        System.out.println(itr.intToRoman(3825));
    }
}
