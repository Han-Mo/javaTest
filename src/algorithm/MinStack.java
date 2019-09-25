package algorithm;

import java.util.Stack;

/**
 * @author han
 * @Date 2019-09-19 09:18
 * 设计一个能获取最小值的栈
 **/
public class MinStack {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    //入栈
    public void push(int element) {
        mainStack.push(element);
        //记录最小值
        if(minStack.empty() || element <= minStack.peek()){
            minStack.push(element);
        }
    }

    //出栈
    public Integer pop() {
        //辅助栈出栈
        if(mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        return mainStack.pop();
    }

    //获取栈中最小值
    public int getMin() throws Exception {
        if (mainStack.empty()) {
            throw new Exception("Stack is empty");
        }

        return mainStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);

        try {
            System.out.println(stack.getMin());
        } catch (Exception e) {
            e.printStackTrace();
        }

        stack.pop();
        stack.pop();
        stack.pop();

        try {
            System.out.println(stack.getMin());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
