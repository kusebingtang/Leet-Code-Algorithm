package org.leetcode.algorithm.array;

/**
 * @author JiangBin
 * @create 2020-07-09 13:28
 */
public class LeetCode_剑指Offer_51_数组中的逆序对 {

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,5,6,4]
     * 输出: 5
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 数组长度 <= 50000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int reversePairs(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        // l < r
        int mid = l + ((r - l) >> 1);
        return
                process(arr, l, mid) //左侧处理产生的逆序对
                        +
                        process(arr, mid + 1, r) //右侧处理产生的
                        +
                        merge(arr, l, mid, r);  //merge过程产生的逆序对
    }

    /**
     * [lIndex,rIndex] 都是闭区间
     * 左边p[lIndex,m]
     * 右边p[m+1,r]
     * @param arr
     * @param lIndex
     * @param m
     * @param rIndex
     * @return
     */
    public static int merge(int[] arr, int lIndex, int m, int rIndex) {
        int[] help = new int[rIndex - lIndex + 1];
        int iIndex = 0;
        int p1 = lIndex;  //辅助记录lIndex merge的位置
        int p2 = m + 1;  //辅助记录rIndex merge的位置
        int res = 0;//计算记录逆序对的个数

        while (p1 <=m && p2 <= rIndex) {
            if (arr[p1] < arr[p2]) {
                help[iIndex++] = arr[p1++];
            } else if (arr[p1] == arr[p2]) {
                help[iIndex++] = arr[p1++];
            } else {  //arr[p1] >  arr[p2]
                res += (m - p1) + 1;
                help[iIndex++] = arr[p2++];
            }
        }

        while (p1 <= m) {
            help[iIndex++] = arr[p1++];
        }
        while (p2 <= rIndex) {
            help[iIndex++] = arr[p2++];
        }

        for (int i = 0; i <help.length ; i++) {
            arr[lIndex+i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,5,6,4};
        System.out.println(reversePairs(arr));
    }
}
