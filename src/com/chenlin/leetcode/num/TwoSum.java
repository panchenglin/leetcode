package com.chenlin.leetcode.num;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hashtable = Maps.newHashMap();
        for(int i = 0; i < nums.length; i++){
            if(hashtable.containsKey(target - nums[i])){
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        int[] sumNums =  twoSum(nums, target);
        System.out.println(sumNums);
    }
}
