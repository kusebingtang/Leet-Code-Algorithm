package org.leetcode.algorithm.array;


/**
 * @author JiangBin
 * @create 2020-03-31 11:57
 */
public class LeetCode_75_颜色分类 {
    /**
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     */

    public static  void sortColors(int[] nums) {
        int zeroIndex = 0;
        int rightTwoIndex = nums.length - 1;
        int index = 0;

        while (index <= rightTwoIndex) {
            if (nums[index] == 0) {
                nums[index++] = nums[zeroIndex];
                nums[zeroIndex++] = 0;
            } else if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[rightTwoIndex];
                nums[rightTwoIndex--] = 2;
            } else {
                throw new RuntimeException("arrays element is not 0-2");
            }
        }


    }

    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        LeetCode_75_颜色分类.sortColors(nums);


        for (int num : nums) {
            System.out.println(num);
        }

    }


}
