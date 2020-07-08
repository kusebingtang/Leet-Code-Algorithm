package basic_class_03;

/**
 * @author JiangBin
 * @create 2020-07-08 12:50
 * <p>
 * 用数组结构实现大小固定的队列和栈
 */
public class Code_01_Array_To_Stack_Queue {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The ArrayStack is full");
            }
            arr[size++] = obj;

        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The ArrayStack is empty");
            }
            return arr[--size];
        }
    }


}
