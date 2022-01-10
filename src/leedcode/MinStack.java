package leedcode;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> mStack;
    private int min = Integer.MAX_VALUE;

    public MinStack(){
        this.stack = new Stack<>();
        this.mStack = new Stack<>();
    }

    public void push(int val){
        if(min<val){
            min = val;
            mStack.push(val);
        }
        stack.push(val);
    }

    public int pop(){
        int out = stack.pop();
        if(out==min){
            mStack.pop();
        }
        return out;
    }

    public int top(){
        return this.stack.peek();
    }

    public int getMin(){
        return this.mStack.peek();
    }

    public static void main(String[] args){

    }
}
