package com.chenlin.leetcode.concurrent;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * 使用一个取模的判断逻辑 C%M ==N，题为 3 个线程，所以可以按取模结果编号：0、1、2，他们与 3 取模结果仍为本身，则执行打印逻辑。
 * @author chenglin
 * @date 2021/1/8
 **/
@Data
public class PrintABCUsingLock {
    private int state;
    private int time;
    private ReentrantLock lock = new ReentrantLock();

    public void write(int num, String name){
        for(int i = 0; i < time;){
            lock.lock();
            try{
                if(state % 3 == num){
                    System.out.println(name);
                    state += 1;
                    i++;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final PrintABCUsingLock usingLock = new PrintABCUsingLock();
        usingLock.setTime(10);
        new Thread(() -> usingLock.write(1, "B"), "B").start();
        new Thread(() -> usingLock.write(0, "A"), "A").start();
        new Thread(() -> usingLock.write(2, "C"), "c").start();

    }
}
