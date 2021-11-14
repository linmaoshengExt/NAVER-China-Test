package com.problem.two;

/**
 * 基于数组实现
 */
public class ArrayStack {
    private int size;//-----数组的长度（栈容量）
    private int top = -1;//-----初始化栈顶元素的下标
    private int[] arr;//-----数组，存放元素

    public ArrayStack() {
        arr = new int[3];//-----设置栈的初始容量为3
    }

    //判断栈容量的设置是否合法
    public ArrayStack(int size) {
        if (size > 0) {
            this.size = size;
            arr = new int[size];
        }
        else throw new RuntimeException("数组长度不正确！");
    }

    //入栈
    public void push(int data) {
        if (top >= size - 1) {
            System.out.println("栈已满，无法进行入栈操作！");
            return;
        }
        arr[++top] = data;
    }

    //出栈
    public int pop() {
        if (top < 0) {
            throw new RuntimeException("栈已空，无法进行出栈操作！");
        } else {
            int temp = arr[top];
            arr[top] = 0;
            top--;
            return temp;
        }
    }

    //查看栈顶元素，但不出栈
    public int peek() {
        if (top < 0) {
            throw new RuntimeException("栈为空！");
        } else {
            return arr[top];
        }
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断栈满
    public boolean isFull() {
        return top == size - 1;
    }

}

