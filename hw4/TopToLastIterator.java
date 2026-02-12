//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;

import java.util.Iterator;
import java.util.*;

public class TopToLastIterator implements Iterator<Card> {
    //Add instance variable/fields  as needed (suggested a list and node)
    private DoubleNode<Card> current;
    private Deck deck;
    private int size;
    public TopToLastIterator(Deck d){
		//put your code here
        this.deck = d;
        this.current = d.getTop();
        this.size = d.size();

    }

    @Override
    public boolean hasNext() {
        //put your code here
        return (current!=null);
    }

    @Override
    public Card next() { //while hasNext is true, we return the current cards data and
        // move on to the next one
        //put your code here
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Card data = current.data;
        current = current.next;
        return data;
    }
}
