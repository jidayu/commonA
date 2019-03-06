package com.jidayu.datastructure;


/**
 * Implementation of the com.jidayu.datastructure.Stack interface using a fixed-length array.
 * Double the size of array if a push operation is attempted
 * when the size of the stack is equal to the length of the array.
 *
 * @author david
 */
public class ArrayStack implements Stack {
    /**
     * Default length of the array used to implement the stack.
     */
    private static final int CAPACITY = 100;

    /**
     * Length of the array used to implement the stack.
     */
    private int capacity;

    /**
     * Array used to implement the stack.
     */
    private Object[] S;

    /**
     * Index of the top element of the stack in the array.
     */
    private int top = -1;

    /**
     * Initialize the stack to use an array of default length CAPACITY.
     */
    public ArrayStack() {
        this(CAPACITY);
    }

    /**
     * Initialize the stack to use an array of given length.
     *
     * @param cap length of the array.
     */
    private ArrayStack(int cap) {
        capacity = cap;
        S = new Object[capacity];
    }

    @Override
    /*
      O(1) time.
     */
    public int size() {
        return (top + 1);
    }

    @Override
    /*
      O(1) time.
     */
    public boolean isEmpty() {
        return (top < 0);
    }

    @Override
    /*
      O(1) time.
      Double the size of the stack if full.
     */
    public void push(Object obj) {
        if (size() == capacity) doubleSize();
        S[++top] = obj;
    }

    /**
     * Double the size of the stack and capacity.
     */
    private void doubleSize() {
        capacity *= 2;
        Object[] temp = new Object[capacity];
        System.arraycopy(S, 0, temp, 0, size());
        S = temp;
    }

    @Override
    /*
      O(1) time.
     */
    public Object top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        return S[top];
    }

    @Override
    /*
      O(1) time.
     */
    public Object pop() throws EmptyStackException {
        Object elem;
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        elem = S[top];
        S[top--] = null; // dereference S[top] for garbage collection.
        return elem;
    }
}
