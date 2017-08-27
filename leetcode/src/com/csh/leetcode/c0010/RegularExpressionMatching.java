package com.csh.leetcode.c0010;

/**
 * Created by jamescsh on 8/26/17.
 */
public class RegularExpressionMatching {
/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */

    public boolean isMatch(String s, String p) {
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=0;i<p.length();i++)
        {
            if(p.charAt(i)=='*' && dp[0][i-1]==true )
                dp[0][i+1]=true;
        }
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<p.length();j++)
            {
                if(p.charAt(j)==s.charAt(i) ||p.charAt(j)=='.'  )
                    dp[i+1][j+1]=dp[i][j];
                else if(p.charAt(j)=='*')
                {
                    dp[i+1][j+1]=dp[i+1][j-1];
                    if(p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i))
                        dp[i+1][j+1]=dp[i+1][j+1]||dp[i][j+1];
                }

            }
        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch("", ""));
    }
}
