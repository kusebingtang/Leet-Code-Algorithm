package org.leetcode.algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author JiangBin
 * @create 2020-04-03 13:38
 * <p>
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_239_滑动窗口最大值 {
    /**
     * 方法二：双向队列
     * 直觉
     * <p>
     * 如何优化时间复杂度呢？首先想到的是使用堆，因为在最大堆中 heap[0] 永远是最大的元素。在大小为 k 的堆中插入一个元素消耗 \log(k)log(k) 时间，因此算法的时间复杂度为 {O}(N \log(k))O(Nlog(k))。
     * <p>
     * 能否得到只要 {O}(N)O(N) 的算法？
     * <p>
     * 我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
     * <p>
     * 存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。
     * <p>
     * 算法
     * <p>
     * 算法非常直截了当：
     * <p>
     * 处理前 k 个元素，初始化双向队列。
     * <p>
     * 遍历整个数组。在每一步 :
     * <p>
     * 清理双向队列 :
     * <p>
     * - 只保留当前滑动窗口中有的元素的索引。
     * <p>
     * - 移除比当前元素小的所有元素，它们不可能是最大的。
     * 将当前元素添加到双向队列中。
     * 将 deque[0] 添加到输出中。
     * 返回输出数组。
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] output = new int[n - k + 1];


        //使用双端队列的关键在于，第一：双端队列保存的是数组的索引值index
        //第二，双端对别保存索引（inde）对用的值（value），值在队列中保存的顺序是从大到小
        Deque<Integer> deque = new LinkedList<>();//

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            //将i加入到队尾
            deque.addLast(i);
            //
            int w = i - (k - 1);
            if (w < 0) continue;

            //检查对头合法性
            if (deque.getFirst() < w) {
                deque.removeFirst();
            }
            output[w] = nums[deque.getFirst()];
        }
        return output;
    }
}
