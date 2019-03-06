package com.jidayu.datastructure;

/**
 * Runtime exception thrown when one tries to perform operation top or pop on an empty stack.
 */
class EmptyStackException extends RuntimeException {
    EmptyStackException(String err) {
        super(err);
    }
}
