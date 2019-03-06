package com.jidayu.datastructure;

public class NodeStack implements Stack {
    private Node top;     // reference to the head node
    private int size;     // number of elements in the stack

    // constructs an empty stack
    public NodeStack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(Object element) {
        top = new Node(element, top);
        size++;
    }

    @Override
    public Object top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        return top.getElement();
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        Object temp = top.getElement();
        top = top.getNext();                // link-out the former top node
        size--;
        return temp;
    }
}
