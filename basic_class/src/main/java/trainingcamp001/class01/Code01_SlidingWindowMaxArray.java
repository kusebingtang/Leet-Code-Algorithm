package trainingcamp001.class01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author JiangBin
 * @create 2020-07-23 12:02
 */
public class Code01_SlidingWindowMaxArray {

    /**
     * 求给定数组滑动窗口最大值
     *
     * @param arr
     * @param w
     * @return
     */
    public static int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        if (w == 1) {
            return arr;
        }

        Deque<Integer> maxToMinDeque = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;

        for (int R = 0; R < arr.length; R++) {
            while (!maxToMinDeque.isEmpty() && arr[maxToMinDeque.peekLast()] <= arr[R]) {
                maxToMinDeque.pollLast();//arr[R]大于队尾，弹出队尾元素
            }
            maxToMinDeque.addLast(R);

            //判定对头元素是否过期
            if (maxToMinDeque.peekFirst() == R - w) {
                maxToMinDeque.pollFirst();//推出对头过期的数组下标
            }
            //R=w-1开始，放入滑动窗口最大值，队首的元素
            if (R >= w - 1) {
                res[index++] = arr[maxToMinDeque.peekFirst()];
            }
        }
        return res;
    }

    // for test
    public static int[] rightWay(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        int L = 0;
        int R = w - 1;
        while (R < arr.length) {
            int max = arr[L];
            for (int i = L + 1; i <= R; i++) {
                max = Math.max(max, arr[i]);

            }
            res[index++] = max;
            L++;
            R++;
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int w = (int) (Math.random() * (arr.length + 1));
            int[] ans1 = getMaxWindow(arr, w);
            int[] ans2 = rightWay(arr, w);
            if (!isEqual(ans1, ans2)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
