//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;
public class Card {
    //add fields
    //suit (♠, ♦, ♥, or ♣), you can assume suit is valid
    private String rank;
    private String suit;


    public Card(String rank, String suit){ //constructor to make new card
        this.rank = rank;
        this.suit = suit;
        //put your code here
    }
	//add code for getters, toString and equals methods.
    public String getRank(){ //following three getters to get objects fields
        return this.rank;
    }
    public String getSuit(){
        return this.suit;
    }
    //@Override
    public String toString(){
        return this.rank+this.suit;
    }
    //@Override
    public boolean equals(Object o){ //equality check on a card by checking its
        //fields against another card
        if(!(o instanceof Card)){
            return false;
        }
        Card temp = (Card)o;
        return (this.rank.equals(temp.getRank()) && this.suit.equals(temp.getSuit()));
    }
}
