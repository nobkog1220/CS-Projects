
public class Card {

    private String rank;
    private String suit;


    public Card(String rank, String suit){ //constructor to make new card
        this.rank = rank;
        this.suit = suit;
    }
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
