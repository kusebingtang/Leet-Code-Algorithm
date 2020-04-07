package org.leetcode.algorithm.stack;

import java.util.Stack;

/**
 * @author JiangBin
 * @create 2020-04-07 13:49
 */
public class LeetCode_739_每日温度 {

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;

        int[] output = new int[T.length];

        //数组下标索引存贮测栈，栈的存储位数组的值从大到小，遇到比存贮大的，pop操作
        Stack<Integer> arrIndexStack = new Stack<>();
        for (int i = 0; i < T.length; i++) {

            while (!arrIndexStack.isEmpty() && T[i] > T[arrIndexStack.peek()]) {
                int topIndex = arrIndexStack.peek();
                output[topIndex] = i-topIndex;
                arrIndexStack.pop();
            }
            arrIndexStack.push(i);
        }
        return output;
    }
}
