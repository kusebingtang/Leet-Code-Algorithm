package org.leetcode.algorithm.sort;

/**
 * @author JiangBin
 * @create 2020-07-07 11:17
 */
public class LeetCode_907_子数组的最小值之和 {
    /**
     * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
     * <p>
     * 由于答案可能很大，因此返回答案模 10^9 + 7。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：[3,1,2,4]
     * 输出：17
     * 解释：
     * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
     * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A <= 30000
     * 1 <= A[i] <= 30000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {

        if (arr == null || arr.length < 1) {
            return 0;
        } else if (arr.length < 1) {
            return arr[1];
        }
        return 0;
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        return 0;
    }
}
