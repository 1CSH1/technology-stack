package com.csh.leetcode.c0013;

/**
 * Created by jamescsh on 8/29/17.
 */
public class RomanToInteger {
/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
    public int romanToInt(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int ret = 0;
        for (int i = 0; !"".equals(s); i ++) {
            while (s.startsWith(roman[i])) {
                ret += nums[i];
                s = s.substring(roman[i].length());
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt("MCM"));
    }
}
