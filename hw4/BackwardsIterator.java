
import java.util.Iterator;
import java.util.NoSuchElementException;
public class BackwardsIterator implements Iterator<Card> {
    private DoubleNode<Card> current;
    private Deck deck;
    private int size;

    public BackwardsIterator(Deck d){
        this.deck = d;
        this.current = d.getLast();
        this.size = d.size();
    }

    @Override
    public boolean hasNext() {
       return(current!=null);
    }

    @Override
    public Card next() { //works similarly to topdown iterator but in this case
        //it starts at the end and goes in reverse
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Card data = current.data; //returns current card data and sets up next
        // card before it to be returned on the next call
        current = current.prev;
        return data;
    }
}

