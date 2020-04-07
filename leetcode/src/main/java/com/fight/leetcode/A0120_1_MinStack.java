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

    /**
     * 辅助栈
     * 入栈时, 最小栈为空或者元素小于等于最小栈栈顶元素,最小栈也入栈
     * 出栈时, 数据栈栈顶元素等于最小栈栈顶元素时,最小栈出栈
     */
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }
        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }
        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return min_stack.peek();
        }
    }

    /**
     * 不用辅助栈
     * 解题思路：
     * 当push（x），x <= min 时先将min进栈，再将x进栈；
     * 也就是说在栈中的每一个min下面都存有前一个min（就是比当前min小的那个）
     */
    class MinStack_2 {
        private Stack<Integer> stack;
        private int min;
        /** initialize your data structure here. */
        public MinStack_2() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(x <= min ){//注意：这里要使用<=号
                stack.push(min);//在每一个min入栈之前将它前一个min入栈
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if(stack.pop() == min){//如果取出来的是当前min，就将压在它低下的前一个min出栈
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }

    /**
     * 使用差值方法
     * 空间复杂度降低到O(n)
     */
    class MinStack_3 {
        long min;
        Stack<Long> stack;

        public MinStack_3(){
            stack=new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                min = x;
                stack.push(x - min);
            } else {
                stack.push(x - min);
                if (x < min){
                    min = x; // 更新最小值
                }
            }
        }

        public void pop() {
            if (stack.isEmpty())
                return;

            long pop = stack.pop();

            //弹出的是负值，要更新 min
            if (pop < 0) {
                min = min - pop;
            }
        }

        public int top() {
            long top = stack.peek();
            //负数的话，出栈的值保存在 min 中
            if (top < 0) {
                return (int) (min);
                //出栈元素加上最小值即可
            } else {
                return (int) (top + min);
            }
        }

        public int getMin() {
            return (int) min;
        }
    }

}
