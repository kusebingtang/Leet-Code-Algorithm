package class02;

public class Code04_RingArray {

    public static class MyQueue {
        private int[] arr;
        private int pushIndex;
        private int pollIndex;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushIndex = 0;
            pollIndex = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("栈满了，不能再加了");
            }
            size++;
            arr[pushIndex] = value;
            pushIndex = nextIndex(pushIndex);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("栈空了，不能再拿了");
            }
            size--;
            int ans = arr[pollIndex];
            pollIndex = nextIndex(pollIndex);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }

    }

}
