package algorithm;

import java.util.Stack;

/**
 * @author han
 * @Date 2019-09-20 09:32
 **/
public class StackQueue {
    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();

    //入栈
    public void enQueue(int element) {
        stackA.push(element);
    }

    /**
      *
      * 出栈
      * @author han
      * @date 09:49 2019-09-20
      * @param
      * @return java.lang.Integer
    */
    public Integer deQueue() {
        if(stackB.isEmpty()) {
            if(stackA.isEmpty()) {
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    /**
      *
      * 转移A栈中的元素到b栈中
      * @author han
      * @date 09:50 2019-09-20
      * @param
      * @return void
    */
    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);

        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());

        stackQueue.enQueue(4);

        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }
}
