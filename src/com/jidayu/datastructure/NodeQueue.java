package com.jidayu.datastructure;

public class NodeQueue implements Queue {
    private Node head;
    private Node tail;
    private int size;

    // constructs an empty queue
    public NodeQueue() {
        head = null;
        tail = null;
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
    public Object front() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyStackException("Queue is empty.");
        return head.getElement();
    }

    @Override
    public void enqueue(Object element) {
        Node node = new Node();
        node.setElement(element);
        node.setNext(null);
        if (size == 0) head = node;
        else tail.setNext(node);
        tail = node;
        size++;
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyStackException("Queue is empty.");
        Object obj = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) tail = null;
        return obj;
    }
}
