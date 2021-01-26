package com.chenlin.leetcode.num;

/**
 * 9.回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
 * @author chenglin
 * 2021/1/26
 */
public class Palindrome {

    public static boolean checkPalindrome(int x){
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int revertedNumber  = 0;
        while (x > revertedNumber ){
            revertedNumber  = x % 10 + revertedNumber  * 10;
            x = x /10;
        }
        return x == revertedNumber  || x == revertedNumber /10;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(checkPalindrome(x));
    }
}
