package org.leetcode.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JiangBin
 * @create 2020-07-11 22:21
 */
public class LeetCode_315_计算右侧小于当前元素的个数 {

    class Pair {
        int index;
        int val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            res.add(0);
            return res;
        }
        Pair[] arr = new Pair[nums.length];
        Integer[] smaller = new Integer[nums.length];
        Arrays.fill(smaller, 0);
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        process(arr, 0, nums.length - 1, smaller);
        res.addAll(Arrays.asList(smaller));
        return res;
    }

    public void process(Pair[] arr, int L, int R, Integer[] smaller) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid, smaller);
        process(arr, mid + 1, R, smaller);
        merge(arr, L, mid, R, smaller);
    }

    public void merge(Pair[] arr, int L, int M, int R, Integer[] smaller) {
        Pair[] help = new Pair[R - L + 1];  //辅助数组
        int helpFillIndex = 0;

        int helpMergeLIndex = L;
        int helpMergeRIndex = M + 1;

        while (helpMergeLIndex <= M && helpMergeRIndex <= R) {
            if (arr[helpMergeLIndex].val <= arr[helpMergeRIndex].val) {
                help[helpFillIndex] = arr[helpMergeLIndex];
                helpFillIndex++;
                helpMergeLIndex++;
                //smaller[arr[helpMergeLIndex].index] += (helpMergeRIndex-M-1);
            } else {
                int smallIndex = helpMergeLIndex;
                while (smallIndex <= M) {
                    smaller[arr[smallIndex].index] = smaller[arr[smallIndex].index] + 1;
                    smallIndex++;
                }
                help[helpFillIndex++] = arr[helpMergeRIndex++];
            }
        }
        while (helpMergeLIndex <= M) {
            help[helpFillIndex++] = arr[helpMergeLIndex++];
        }

        while (helpMergeRIndex <= R) {
            help[helpFillIndex++] = arr[helpMergeRIndex++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        LeetCode_315_计算右侧小于当前元素的个数 test = new LeetCode_315_计算右侧小于当前元素的个数();

        int[] nums = {5, 2, 6, 1};
        int[] nums2 = {};

        System.out.println(test.countSmaller(nums2));


    }

}
