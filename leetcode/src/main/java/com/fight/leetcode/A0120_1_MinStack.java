package com.fight.leetcode;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
 */
public class A0120_1_MinStack {

    public static void main(String[] args) {

    }

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                Integer peek = minStack.peek();
                if (x <= peek) {
                    minStack.push(x);
                }
            }
        }

        public void pop() {
            Integer pop = stack.pop();
            if (!stack.isEmpty()) {
                if (pop.equals(minStack.peek())) {
                    minStack.pop();
                }
            } else {
                minStack.pop();
            }

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
