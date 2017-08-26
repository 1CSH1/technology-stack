package com.csh.leetcode.c0009;

/**
 * Created by jamescsh on 8/26/17.
 */
public class PalindromeNumber {
/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 */

    /*
    Time complexity: O(logn)
    Space complexity: O(1)
     */
    public boolean isPalindrome(int x) {
        // 小于 0 返回 false
        if (x < 0) {
            return false;
        }
        // 可以被 10 整除的除了 0 之外都是非回文串数字
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        // ret 记录反数字，循环x数字长度的一半就可以
        int ret = 0;
        while (x > ret) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }

        return (x == ret) || (x == ret / 10);
    }
}
