//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardsIterator implements Iterator<Card> {
    //Add instance variable/fields  as needed (suggested a list and node)
    private DoubleNode<Card> current;
    private Deck deck;
    private int size;

    public BackwardsIterator(Deck d){
        this.deck = d;
        this.current = d.getLast();
        this.size = d.size();
        //put your code here
    }

    @Override
    public boolean hasNext() {
       //put your code here
       return(current!=null);
    }

    @Override
    public Card next() { //works similarly to topdown iterator but in this case
        //it starts at the end and goes in reverse
        //put your code here
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Card data = current.data; //returns current card data and sets up next
        // card before it to be returned on the next call
        current = current.prev;
        return data;
    }
}

