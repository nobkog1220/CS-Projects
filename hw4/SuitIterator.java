//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuitIterator implements Iterator<Card> {
    //add instance variable/fields  as needed (suggested a list and node and suit)
    private DoubleNode<Card> current;
    private Deck d;
    private String suit;
    private int size;

    public SuitIterator(Deck d, String suit){ //within the constructor
        // we loop through the deck to get to the first valid card given the suit
        this.current = d.getTop();
        this.d = d;
        this.suit = suit;
        this.size = d.size();
        while(current != null && !(current.data.getSuit().equals(this.suit)) ){
            current = current.next;
        }

        //put your code here

    }
    @Override
    public boolean hasNext() {
        //put your code here
        return(current!=null);

    }
    @Override
    public Card next() { //at this point we have the first valid card
        // so we save its data and move to the next card
        //then we do the same while loop process of moving to the next valid card
        //which in the ordered deck should be right after it
        //once the while loop stops we return the valid card we found
        //and our next valid card has been found to continue the iterator
        //put your code here
        if(!hasNext()){
            throw new NoSuchElementException();
        }

        Card data = current.data;
        current = current.next;
        while(current != null && !(current.data.getSuit().equals(this.suit)) ){
            current = current.next;
        }
        return data;
	}
}