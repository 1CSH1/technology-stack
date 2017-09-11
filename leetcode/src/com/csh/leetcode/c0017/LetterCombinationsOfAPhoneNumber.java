package com.csh.leetcode.c0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jamescsh on 9/5/17.
 */
public class LetterCombinationsOfAPhoneNumber {
/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

    public List<String> letterCombinations(String digits) {
        List<String> retList = new ArrayList<String>();
        if (null == digits || digits.length() == 0) {
            return retList;
        }
        String[] dict = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        retList.add("");
        for (int i = 0; i < digits.length(); i ++) {
            int n = retList.size();
            String lett = dict[digits.charAt(i) - '0'];
            // 循环已存在的数组
            List<String> removeList = new ArrayList<>();
            for (int j = 0; j < n; j ++) {
                // 循环新的数字代表的字符
                String comb = retList.get(j);
                removeList.add(comb);
                List<String> tempList = new ArrayList<>();
                for (int k = 0; k < lett.length(); k ++) {
                    String temp = comb + lett.charAt(k);
                    tempList.add(temp);
                }
                retList.addAll(tempList);
            }
            retList.removeAll(removeList);
        }

        return retList;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> ret = letterCombinationsOfAPhoneNumber.letterCombinations("23");
        ret.forEach(a -> System.out.println(a));
    }
}
