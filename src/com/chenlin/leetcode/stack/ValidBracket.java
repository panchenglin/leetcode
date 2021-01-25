package com.chenlin.leetcode.stack;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
 */
public class ValidBracket {
    public static boolean checkValid(String str){
        if(Strings.isNullOrEmpty(str) || str.length() % 2 == 1){
            return false;
        }
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        Deque<Character> linkList = Lists.newLinkedList();
        for(int i = 0; i < str.length(); i++){
            if(bracketMap.containsKey(str.charAt(i))){
                if(linkList.isEmpty() || !linkList.peek().equals(bracketMap.get(str.charAt(i)))){
                    return false;
                }
                linkList.poll();
            }else {
                linkList.push(str.charAt(i));
            }
        }
        return linkList.isEmpty();
    }

    public static void main(String[] args) {
        String str = "([]){}[]";
        System.out.println(checkValid(str));
    }
}
