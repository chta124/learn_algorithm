package cn.com.tangpzh.week01;

import java.util.Stack;

public class MinStack2 {

    // 存放数据的栈
    private Stack<Integer> dataStack = new Stack<Integer>();
    // 存放最小值的栈
    private Stack<Integer> minNumStack = new Stack<Integer>();
    public MinStack2() {
        // 默认放一个最大值入栈
        minNumStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        dataStack.push(val);
        // 最小值栈中压入一个当前的最小值
        minNumStack.push(Math.min(minNumStack.peek(), val));
    }

    public void pop() {
        if(dataStack.empty()){
            return;
        }
        dataStack.pop();
        minNumStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minNumStack.peek();
    }

}
