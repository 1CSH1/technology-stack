package com.csh.leetcode.c0008;

/**
 * Created by jamescsh on 8/24/17.
 */
public class StringToIntegeratoi {

/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

    public int myAtoi(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        long ret = 0;
        int i = 0;
        boolean canUse = false;
        boolean isFirst = true;
        int net = 1;
        while (i < str.length()) {
            if (!canUse & str.charAt(i) != ' ' && str.charAt(i) != '0') {
                canUse = true;
            }
            if (canUse) {
                if (isFirst) {
                    isFirst = false;
                    if (str.charAt(i) == '-') {
                        net = -1;
                        i ++;
                        continue;
                    } else if (str.charAt(i) == '+') {
                        net = 1;
                        i ++;
                        continue;
                    }
                }
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    ret = ret * 10 + (str.charAt(i) - 48);
                    if (ret * net > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (ret * net < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }

                } else {
                    break;
                }
            }
            i ++;
        }
        return (int)ret * net;
    }

    /*
    优化版本：分为3个阶段来计算，避免在一个循环里面多次不必要的比较
     */
    public int myAtoi2(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        long ret = 0;
        int length = str.length();
        int i = 0;
        boolean canUse = false;
        boolean isFirst = true;
        int net = 1;

        // 得到首个要计算的值
        while (i < length) {
            if (str.charAt(i) != ' ' && str.charAt(i) != '0') {
                break;
            }
            i ++;
        }

        // 判断是正负
        if (str.charAt(i) == '+') {
            net = 1;
            i ++;
        } else if (str.charAt(i) == '-') {
            net = -1;
            i ++;
        }

        // 真实的数字
        int value = 0;
        long retTemp = 0;
        int compact = (net == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        boolean isNet = (net == -1);
        while (i < length) {
            value = str.charAt(i) - '0';
            if (value < 0 || value > 9) {
                break;
            }
            ret = ret * 10 + value;
            retTemp = ret * net;
            if (isNet) {
                if (retTemp < compact) {
                    return compact;
                }
            } else {
                if (retTemp > compact) {
                    return compact;
                }
            }
            i ++;
        }
        return (int)retTemp;

    }

    public static void main(String[] args) {
        StringToIntegeratoi s = new StringToIntegeratoi();
        System.out.println(s.myAtoi("123"));
        System.out.println("0".charAt(0));
        System.out.println("9".charAt(0));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
