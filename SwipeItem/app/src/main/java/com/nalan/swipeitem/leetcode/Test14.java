package com.nalan.swipeitem.leetcode;

import java.util.Arrays;

/**
 * Created by ShiLiang on 2018/5/1.
 */

/*
*
* 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
* */
public class Test14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuffer res = new StringBuffer();
        Arrays.sort(strs);
        String s1 = strs[0], s2 = strs[strs.length - 1];
        for (int i = 0; i < s1.length(); i++) {
            if (s2.length() > i && s2.charAt(i) == s1.charAt(i))
                res.append(s1.charAt(i));
            else return res.toString();
        }
        return res.toString();
    }
}
