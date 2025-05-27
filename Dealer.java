import java.util.LinkedList; // imports LinkedList from java

public class Dealer { // initializes body for public class Dealer

    private Deck m_deck; // declares private variable m_deck as type Deck

    public Dealer() { // default constructor for class Dealer
        m_deck = new Deck(); // creates a new Deck of 52 cards and assigns it to m_deck
        // m_deck uses default constructor Deck() from class Deck
    }
    
    public LinkedList<Card> deals(int n) { // a public method that deals Cards randomly from m_deck and puts them in a new LinkedList
        // takes parameter n as type int that represents the number of Cards to be dealt
        LinkedList<Card> n_cards = new LinkedList<>(); // creates a new LinkedList of type Card called n_cards
        // this new LinkedList stores the values of dealt Cards
        for (int i = 0; i < n; i++) { // for each Card to be dealt from m_deck
            Card c = m_deck.deal(); // call class Deck's deal() method that deals and removes a random Card from m_cards
            // assign the result of deal() to variable c as type Card
            n_cards.add(c); // add Card c, the dealt card, to LinkedList n_cards
        }
        return n_cards; // returns n_cards as type LinkedList<Card>
        // this represents all cards no longer in m_deck
    }

    public int size() { // a public method that gets the size of Deck m_deck
        int i = m_deck.size(); // int i is assigned to the current number of Cards
        return i; // returns size as type int
    }

    public String toString() { // a public method that displays the contents of m_deck as a String
        String s = ""; // creates a blank String s to store the full String
        s += m_deck.toString(); // Deck m_deck's toString() method that converts m_deck into a String
        return s; // returns String s with Deck details
    }

}
