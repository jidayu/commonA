package com.jidayu.datastructure;


/**
 * Interface for a queue: a collection of objects that are inserted
 * and removed according to the first-in first-out principle.
 *
 * @author david
 * @see EmptyQueueException
 */
public interface Queue {
    /**
     * Return the numbers of elements in the queue.
     * @return number of elements in the queue.
     */
    int size();

    /**
     * Return whether the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Inspects the element at the front of the queue.
     * @return element at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    Object front() throws EmptyQueueException;

    /**
     * Insert an element at the rear of the queue.
     * @param element new element to be inserted.
     */
    void enqueue(Object element);

    /**
     * Removes the element at the front of the queue.
     * @return element removed.
     * @throws EmptyQueueException if the queue is empty.
     */
    Object dequeue() throws EmptyQueueException;
}
