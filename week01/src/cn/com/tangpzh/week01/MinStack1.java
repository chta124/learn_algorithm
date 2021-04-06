package cn.com.tangpzh.week01;

import java.util.Stack;

public class MinStack1 {

    private Stack<Integer> stack = new Stack<Integer>();
    private Integer minNum = null;
    public MinStack1() {

    }

    public void push(int val) {
        stack.push(val);
        if(minNum == null){
            minNum = val;
        }else if(val < minNum){
            minNum = val;
        }
    }

    public void pop() {
        if(stack.empty()){
            return;
        }
        int val = stack.pop();
        if(stack.empty()){
            minNum = null;
            return;
        }
        // 如果本次pop出的元素是最小值，则需要重新找一个最小值
        if(minNum.intValue() == val){
            // 重新找出最小值
            Integer temp = Integer.MAX_VALUE;
            for (Integer x : stack) {
                temp = Math.min(temp, x);
            }
            minNum = temp;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minNum;
    }

}
