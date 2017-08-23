package com.csh.leetcode.c00007;

/**
 * Created by jamescsh on 8/23/17.
 */
public class ReverseInteger {
/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

 */

    public int reverse(int x) {
        try {
            if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE || x == 0) {
                return 0;
            }

            String ret = "";
            if (x < 0) {
                x = -x;
                ret += "-";
            }
            String s = String.valueOf(x);
            int i = s.length() - 1;
            boolean can = false;
            while (i >= 0) {
                if (!can && '0' != s.charAt(i)) {
                    can = true;
                }
                if (can) {
                    ret += s.charAt(i);
                }
                i--;
            }

            return Integer.parseInt(ret);
        } catch (Exception e) {
            return 0;
        }
    }

    /*
    每一次循环把最后一位的字符移到第一位
     */
    public int reverse2(int x) {
        long ret = 0;
        while (x != 0) {
            int a = x % 10;
            x = x / 10;
            ret = ret * 10 + a;
            if (ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int)ret;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-100));
        System.out.println(ri.reverse(-1001));
//        System.out.println(ri.reverse(9646324351));
//        System.out.println(ri.reverse(Integer.MAX_VALUE + 1));
    }
}
