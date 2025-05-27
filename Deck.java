import java.util.LinkedList; // imports LinkedList from java
import java.util.Random; // imports Random from java

public class Deck { // initializes body for public class Deck

    private LinkedList<Card> m_cards; // declares private variable m_cards as a LinkedList of type Card

    public Deck() { // default constructor for class Deck
        // a default fresh deck contains 52 cards
        m_cards = new LinkedList<>(); // creates a new LinkedList for m_cards
        for (int i = 2; i < 15; i++) { // for all ranks numbered 2 through 14
            for (int j = 0; j < 4; j++) { // for all suits numbered 0 to 3
                Card c = new Card(i, j); // create a new Card for each rank and suit
                m_cards.add(c); // add each Card to LinkedList m_cards
            }
        }
    }

    public Deck(Deck d) { // copy constructor for class Deck
        // takes parameter d as type Deck and copies its contents as a new Deck
        m_cards = d.m_cards; // copies LinkedList of Deck d
    }

    public int size() { // a public method that gets the size of LinkedList<Card> m_cards
        int i = m_cards.size(); // int i is assigned to the current number of Cards
        return i; // returns size as type int
    }

    public Card deal() { // a public method that deals a random card from LinkedList m_cards 
        Random rand = new Random(); // Random is called from java's built in methods and is assigned to rand of type Random
        int i = rand.nextInt(m_cards.size()); // int i is assigned to a random int between 0 and less than the length of m_cards (inclusive)
        Card c = m_cards.get(i); // m_cards gets the Card at position i in the LinkedList and assigns it to c as type Card
        m_cards.remove(i); // Card c is removed from m_cards
        return c; // the removed (dealt) Card is returned as type Card
    }

    public String toString() { // a public method that displays the contents of m_cards as a String
        String s = ""; // creates a blank String s to store the full String
        s += m_cards.toString(); // LinkedList<Card> m_cards's toString() method that converts m_cards into a String
        return s; // returns String s with LinkedList details
    }


}
