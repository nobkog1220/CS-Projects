

import java.util.Iterator;
import java.util.*;

public class TopToLastIterator implements Iterator<Card> {
    //Add instance variable/fields  as needed (suggested a list and node)
    private DoubleNode<Card> current;
    private Deck deck;
    private int size;
    public TopToLastIterator(Deck d){
        this.deck = d;
        this.current = d.getTop();
        this.size = d.size();

    }

    @Override
    public boolean hasNext() {
        return (current!=null);
    }

    @Override
    public Card next() { //while hasNext is true, we return the current cards data and
        // move on to the next one
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Card data = current.data;
        current = current.next;
        return data;
    }
}
