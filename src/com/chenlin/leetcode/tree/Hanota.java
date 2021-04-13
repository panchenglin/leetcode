package com.chenlin.leetcode.tree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 汉诺塔问题
 * https://leetcode-cn.com/problems/hanota-lcci/solution/java-di-gui-jie-jue-lao-sheng-chang-tan-de-yi-nuo-/
 * @author bjpanhongwei
 * @date 2021/3/9
 **/
class Hanota {
    /**
     * 将 A 上的所有盘子，借助 B，移动到C 上
     * @param A 原柱子
     * @param B 辅助柱子
     * @param C 目标柱子
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlate(A.size(), A, B, C);
    }

    private void movePlate(int num, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
        // 只剩一个盘子时，直接移动即可
        if (num == 1) {
            target.add(original.remove(original.size() - 1));
            return;
        }
        // 将 size-1 个盘子，从 original 移动到 auxiliary
        movePlate(num - 1, original, target, auxiliary);
        // 将 第size个盘子，从 original 移动到 target
        target.add(original.remove(original.size() - 1));
        // 将 size-1 个盘子，从 auxiliary 移动到 target
        movePlate(num - 1, auxiliary, original, target);
    }

    private static void hanota1(List<Integer> A, List<Integer> B, List<Integer> C) {
        //得到盘子总数
        int n =A.size();
        func(n,A,B,C);
    }

    private static void func(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        //当盘子都移动空了之后停止递归
        if(n<=0){
            return;
        }
        //将A上面的 n-1 个圆盘经由 C 移到 B
        func(n-1,A,C,B);
        //此时将 A 底下的那块最大的圆盘移到 C
        C.add(A.remove(A.size()-1));
        // 再将 B 上的 n-1 个圆盘经由A移到 C上
        func(n-1,B,A,C);
    }



    public static void main(String[] args) {
        List<Integer> A = Lists.newArrayList(3,2,1,0);
        List<Integer> B = Lists.newArrayList();
        List<Integer> C = Lists.newArrayList();
        hanota1(A,B,C);
        System.out.println(C);
    }
}

