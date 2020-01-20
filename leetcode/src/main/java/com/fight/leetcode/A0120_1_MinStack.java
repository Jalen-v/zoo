package com.fight.leetcode;

import java.util.Stack;

public class A0120_1_MinStack {

    public static void main(String[] args) {

    }

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
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
            if(!stack.isEmpty()) {
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
