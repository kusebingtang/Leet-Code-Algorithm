package org.leetcode.algorithm.array;

/**
 * @author JiangBin
 * @create 2020-03-31 13:53
 */
public class LeetCode_面试题_16_16_部分排序 {

    /**
     * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
     * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
     * <p>
     * 示例：
     * <p>
     * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
     * 输出： [3,9]
     * 提示：
     * <p>
     * 0 <= len(array) <= 1000000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param array
     * @return
     */
    public static int[] subSort(int[] array) {

        if (array == null || array.length <= 1) return new int[]{-1, -1};

        int length = array.length;
        //从左往右找逆序对，记录最大的值max，比最大的max小的话，rightIndex++
        int max = array[0];
        int rightIndex = -1;
        for (int i = 1; i < length; i++) {
            int value = array[i];
            if (value >= max) {
                max = value;
            } else {
                rightIndex = i;
            }
        }
        if (rightIndex == -1) return new int[]{-1, -1};
        int min = array[length - 1];
        int leftIndex = -1;
        //从右往左找逆序对，记录最小的值min，比最小的min小的话，rightIndex--
        for (int i = length - 2; i >=0 ; i--) {
            int value = array[i];
            if (value <= min) {
                min = value;
            } else {
                leftIndex = i;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] returnArray = LeetCode_面试题_16_16_部分排序.subSort(array);

        for (int index : returnArray) {
            System.out.println(index);
        }

    }

}
