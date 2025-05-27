public class TestCards { // initializes body for public class TestCards
    // this class is the main that tests all methods from Card, Deck, and Dealer classes

    public static void main(String[] args) { // main method declared

        // TESTS for class Card
        
        System.out.println(); // newline for neatness
        Card a = new Card(); // creates default Card a ACE OF SPADES 
        System.out.println("Card A: " + a); // prints Card a
        System.out.println("Card A Rank: " + a.getRank()); // prints the rank of Card a as an integer
        // this should be 14 since it is an ACE
        System.out.println("Card A Suit: " + a.getSuit()); // prints the suit of Card a as an integer
        // this should be 1 since it is SPADES
        Card b = new Card(6, 3); // creates overloaded Card b 6 OF DIAMONDS with numbers 
        System.out.println("Card B: " + b); // prints Card b
        Card c = new Card(a); // creates Card c as a copy of Card a
        System.out.println("Card C: " + c); // prints Card c, the same as Card a
        c.setSuit(2); // sets suit of Card c to CLUBS
        System.out.println("Card C: " + c); // prints Card c, ACE OF CLUBS

        System.out.println("Are Card C and Card A the same? : " + c.equals(a)); // uses equals() to compare Cards c and a
        // this should return true since the ranks of both a and c are the same
        System.out.println("Are Card B and Card A the same? : " + b.equals(a)); // uses equals() to compare Cards b and a
        // this should return false
        c.setRank(2); // sets rank of Card c to 2
        System.out.println("Card C: " + c); // prints Card c
        System.out.println("Are Card C and Card A the same? : " + c.equals(a)); // uses equals() to compare Cards c and a
        // this should return false
        Card d = new Card(Card.KING, Card.HEARTS); // creates Card d KING OF HEARTS using constant variables
        System.out.println("Card D: " + d); // prints Card d
        
        // TESTS for class Deck

        System.out.println(); // newline for neatness
        Deck d1 = new Deck(); // creates default LinkedList d1 of 52 cards
        System.out.println("Deck Size: " + d1.size()); // prints the size of LinkedList d1
        // this should say 52
        System.out.println("Deal 1: " + d1.deal()); // deals a random Card from d1 and returns the Card value
        System.out.println("Deal 2: " + d1.deal()); // deals a random Card from d1 and returns the Card value
        System.out.println("Deck Size: " + d1.size()); // prints the size of LinkedList d1
        // this should say 50 since 2 deals were made
        Deck d2 = new Deck(d1); // creates a copy of Deck d1 and assigns it to d2
        System.out.println("Deck2 Size: " + d2.size()); // retrieves the size of d2
        // this should still be 50 since we created a copy 

        // TESTS for class Dealer

        System.out.println(); // newline for neatness
        System.out.println("NEW GAME"); // fun little statmenet cuz why not
        System.out.println("--------"); // decoration
        System.out.println(); // newline for neatness

        Dealer dl = new Dealer(); // creates default Deck dl of 52 cards
        System.out.println("Deck Size: " + dl.size()); // prints the size of Deck dl
        // this should say 52
        System.out.println("Current Deals: " + dl.deals(0)); // prints an empty list of 0 Cards
        System.out.println("Deals 1-10: " + dl.deals(10)); // prints a list of 10 Cards randomly dealt from the Deck's deal() method
        System.out.println(); // newline for neatness

        System.out.println("In Deck: " + dl); // prints Cards remaining in Deck dl as a list
        // any cards mentioned in Deals 1-10 should not be in this list
        System.out.println("Deck Size: " + dl.size()); // prints the size of Deck dl
        // this should say 42 since 10 deals were made

        System.out.println(); // newline for neatness
        System.out.println("END OF CARD GAME ;>"); // fun little statement because why not

    }

}
