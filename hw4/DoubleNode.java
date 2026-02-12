//package com.gradescope.hw4;

public class DoubleNode<T> {
    //add instance variables/fields to match picture in directions
    DoubleNode<T> prev;
    T data;
    DoubleNode<T> next;
    //Constructor with data, calls constructor with prev, data, next
    public DoubleNode(T data){
        //initialize all fields
        this(null,data,null);
    }
    //Constructor with provided prev and next
    public DoubleNode(DoubleNode<T> prev, T data, DoubleNode<T> next){
        //initialize all fields use this key word
        this.prev = prev;
        this.next = next;
        this.data = data;
    }
}

