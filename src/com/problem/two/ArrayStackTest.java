package com.problem.two;


/**
 * 测试类
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);//设置栈容量为5

        System.out.println(stack.isEmpty());//true

        //入栈
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);

        System.out.println(stack.isFull());//true

        System.out.println(stack.peek());//9

        System.out.println(stack.pop());//9
        System.out.println(stack.pop());//7
        System.out.println(stack.pop());//5

        System.out.println(stack.isEmpty());//false
        System.out.println(stack.peek());//3

        System.out.println(stack.pop());//3
        System.out.println(stack.pop());//1

        System.out.println(stack.isEmpty());//true

    }
}

