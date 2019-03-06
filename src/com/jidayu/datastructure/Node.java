package com.jidayu.datastructure;

class Node {
    // Instance variables:
    private Object element;
    private Node next;

    /**
     * Creates a node with null references to its element and next node.
     */
    Node() {
        this(null, null);
    }

    /**
     * Creates a node with the given element and the next node.
     */
    public Node(Object e, Node n) {
        element = e;
        next = n;
    }

    // Accessor methods
    Object getElement() {
        return element;
    }

    Node getNext() {
        return next;
    }

    // Modifier methods
    void setElement(Object element) {
        this.element = element;
    }

    void setNext(Node next) {
        this.next = next;
    }
}
