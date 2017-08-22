package com.csh.leetcode.c0006;

/**
 * Created by jamescsh on 8/22/17.
 */
public class ZigZagConversion {
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] c = new char[numRows][1000];
        // i: 行 j: 列 k: 遍历字符串
        int i = 0, j = 0, k = 0, m = 0, n = 0;
        String result = "";

        int length = s.length();
        while (k < length) {
            i += m;
            j += n;
            c[i][j] = s.charAt(k);

            // 控制上下移动的方向
            if (i == 0) {
                m = 1;
                n = 0;
            } else if (i == numRows - 1) {
                m = -1;
                n = 1;
            }
            k ++;
        }

        for (int h=0; h<numRows; h++) {
            for (int u=0; u<=j; u++){
                if ((int)c[h][u] != 0) {
                    result += c[h][u];
                }

            }
        }

        return result;
    }

    public String convert2(String s, int numRows) {
        int len = s.length();
        if (len == 0 || numRows < 2){
            return s;
        }

        String result = "";
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++){
            for (int j = i; j < len; j += step){
                result += s.charAt(j);

                if (i > 0 && i < numRows - 1){
                    //非首行
                    int last = j + step - 2 * i;
                    if (last < len){
                        result += s.charAt(last);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ZigZagConversion z = new ZigZagConversion();
        System.out.println(z.convert("PAYPALISHIRING", 3));
        System.out.println(z.convert("AB", 1));
        System.out.println(z.convert2("PAYPALISHIRING", 3));
    }
}
