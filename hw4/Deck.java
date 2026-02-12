//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;




import java.util.*;

public class Deck implements Iterable<Card> { //make implements Iterable<Card>
    // so that decks can be iterated over by the iterator
    private DoubleNode<Card> top;
    private DoubleNode<Card> last;
    private int size;
    //Default constructor that generates a full list of card in specific order
    //top [A♥, 2♥,..., K♥, A♦, ..., K♦, A♣, ..., K♣, A♠, ..., K♠] last
    public Deck(){
        //put your code here
        //default constructor builds a standard deck with a base of suits and ranks
        this.top = null;
        this.last = null;
        this.size = 0;
        String[] suits = {"\u2665","\u2666","\u2663","\u2660"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9","10", "J", "Q", "K"};
        for(String suit: suits){
            for(String rank: ranks){ //for each rank of each suit
                // make a new card with that info and a new node to hold it
                Card newCard = new Card(rank, suit);
                DoubleNode<Card> newNode = new DoubleNode<>(newCard);
                if(this.top == null){ //if this card would be the first node
                    this.top = newNode;
                    this.last = newNode;
                }
                else {
                    //a new card is added, newNode.prev which is
                    //our new nodes previous pointer gets assigned to this.last
                    // which is our first node in the list
                    newNode.prev = this.last; // needed so when I add the task node the nodes
                    //previous task becomes the last task in the chain
                    //then the first previous nodes next pointer becomes the current
                    //node
                    this.last.next = newNode;
                    //then the last pointer goes to the added node
                    this.last = newNode;
                }
                this.size++;

            }

        }
    }
    //Constractor requires array of cards
    public Deck(Card[] arr){
        //put your code here
        this.top = null;
        this.last = null;
        this.size = 0;


        if(arr == null){
            return;
        }
        else {
            for (Card card : arr) { //similar structure to the above constructor
                // but this time it loops through the given arr of cards
                DoubleNode<Card> newNode = new DoubleNode<>(card);
                if (this.top == null) {
                    this.top = newNode;
                    this.last = newNode;
                } else {
                    newNode.prev = this.last; // needed so when I add the task node the nodes
                    //previous task becomes the last task in the chain
                    this.last.next = newNode;
                    this.last = newNode;
                }
                this.size++;

            }
        }




    }
    //Add getters
    //put your code here
    //getters to get the fields, needed later in the iterators
    public int size(){
        return this.size;
    }
    public DoubleNode<Card> getTop(){
        return this.top;
    }
    public DoubleNode<Card> getLast(){
        return this.last;
    }
    //add toString methods: card in their order starting from top to the last
    //For example, if used Default constructor: [A♥, 2♥,..., K♥, A♦, ..., K♦, A♣, ..., K♣, A♠, ..., K♠]
    public String toString(){ //makes a string representation of the deck
        // looping through the deck and adding each nodes data between brackets
        String ans;
        DoubleNode temp = this.top;
        if (size == 0) {
            return "[]";
        } else {
             ans = "[" + this.top.data;
            for (int i = 1; i < size; i++) {
                temp = temp.next;
                ans = ans + (", " + temp.data);
            }
            ans += "]";
        }
        //put your code here
        return ans;
    }
    //add default iterator (don't forget to add implements to class, if needed)
    public Iterator<Card> iterator(){ //adds default iterator so that iterators can be used

        return new TopToLastIterator(this);

    }

}
