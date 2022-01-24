package com.codegym.exception;

public class OutOfStock extends Exception {
    public OutOfStock() {
        super("This book is out of stock!");
    }

    public OutOfStock(String message) {
        super(message);
    }
}
