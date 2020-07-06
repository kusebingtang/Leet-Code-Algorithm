package basic_class_01;

import java.util.Arrays;

/**
 * @author JiangBin
 * @create 2020-07-06 11:43
 * <p>
 * <p>
 * 堆排序
 */
public class Code_03_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);  //1、建堆
        }
        int size = arr.length;
        swap(arr, 0, --size);//大顶堆堆顶元素放入到数组最后的位置，//然后对[0,size-1]继续堆化，完成堆排序功能
        while (size > 0) {
            heapify(arr, 0, size);
            if (size > 1) {
                swap(arr, 0, (size - 1));
            }
            size--;//调整堆大小
        }
    }

    /**
     * 对最后放入的index，进行建堆操作
     * 和插入节点的父节点((index-1/2))比较大小，不断的向上交换移动
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * @param arr
     * @param index 插入的元素index
     * @param size  参与堆化数组的大小
     */
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1; //左孩子
        while (left < size) {
            //选出左右孩子大的节点index
            int largestIndex = left + 1 < size && arr[left] < arr[left + 1] ? left + 1 : left;
            //和父节点index比大小
            largestIndex = arr[largestIndex] > arr[index] ? largestIndex : index;
            if (largestIndex == index) {
                break;
            }
            swap(arr, largestIndex, index);//交互
            index = largestIndex;//继续子节点比较，直到叶子节点
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
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

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }


}
