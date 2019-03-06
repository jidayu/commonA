package com.jidayu.datastructure;


/**
 * Implementation of the com.jidayu.datastructure.Queue interface using a fixed-length array.
 * Double the size of array if an enqueue operation is attempted
 * when the size of the queue is equal to the length of the array.
 * Circular array.
 *
 * @author david
 */
public class ArrayQueue implements Queue {
    /**
     * Default length of the array used to implement the queue.
     */
    private static final int CAPACITY = 100;

    /**
     * Length of the array used to implement the queue.
     */
    private int capacity;

    /**
     * Array used to implement the queue.
     */
    private Object[] Q;

    /**
     * Index of the front element of the queue in the array.
     */
    private int f = 0;

    /**
     * Index of the next available array cell in array.
     */
    private int r = 0;

    /**
     * Initialize the stack to use an array of default length CAPACITY.
     */
    public ArrayQueue() {
        this(CAPACITY);
    }

    /**
     * Initialize the stack to use an array of given length.
     *
     * @param cap length of the array.
     */
    private ArrayQueue(int cap) {
        capacity = cap;
        Q = new Object[capacity];
    }

    @Override
    /*
      O(1) time.
     */
    public int size() {
        return (capacity - f + r)%capacity;
    }

    @Override
    /*
      O(1) time.
     */
    public boolean isEmpty() {
        return f == r;
    }

    @Override
    /*
      O(1) time.
     */
    public Object front() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Queue is empty.");
        return Q[f];
    }

    @Override
    /*
      O(1) time.
     */
    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Queue is empty.");
        Object temp = Q[f];
        Q[f] = null;
        f = (f + 1) % capacity;
        return temp;
    }

    @Override
    /*
      O(1) time.
      Double the size of the queue if full.
     */
    public void enqueue(Object element) {
        if (size() == capacity-1) doubleSize();
        Q[r] = element;
        r = (r + 1) % capacity;
    }

    /**
     * Double the size of the queue and capacity.
     */
    private void doubleSize() {
        f = 0;
        r = size();
        capacity *= 2;
        Object[] temp = new Object[capacity];
        int index = 0;
        while (!isEmpty()) {
            temp[index++] = dequeue();
        }
        Q = temp;
    }
}
