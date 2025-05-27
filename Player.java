import java.util.LinkedList; // imports linkedlist from java

public class Player { // creates body for class Player

    private int playerNum; // a private member variable that identifies the Player's number
    private LinkedList<Card> hand; // a private member variable for a Player's cards in hand
    private String pattern; // a private member variable for a Player's pattern

    public Player(int pNum, LinkedList<Card> h, String p) { // an overloaded constructor for Player
        // takes in a playerNum, hand, and pattern and assigns it to a Player's member variables
        playerNum = pNum;
        hand = h;
        pattern = p;
    }

    public Card playCard() { // a public method that removes a card from the top of the player's hand and returns it
        Card c = hand.get(0); // position 0 in hand is the Player's top card and is assigned to c
        hand.remove(c); // top card is removed from hand
        return c; // removed card value is returned
    }

    public boolean slaps(LinkedList<Card> pile) {
        // a public method slaps that takes in a pile to evaluate if a pattern is in play
            if (pattern.equals("topBottom") && Game.topBottom(pile)) {
                // calls the player's pattern variable to see if it's topBottom
                // the topBottom static method is called from Game to check if the pile matches the pattern
                // if both values are true, return true to play the topBottom slap
                return true;
            }
            if (pattern.equals("sandwich") && Game.sandwich(pile)) {
                // calls the player's pattern variable to see if it's sandwich
                // the sandwich static method is called from Game to check if the pile matches the pattern
                // if both values are true, return true to play the sandwich slap
                return true;
            }
            if (pattern.equals("doubles") && Game.doubles(pile)) {
                // calls the player's pattern variable to see if it's doubles
                // the doubles static method is called from Game to check if the pile matches the pattern
                // if both values are true, return true to play the doubles slap
                return true;
            }
        return false; // returns false if no patterns are in play
    }

    public int getPlayerNum() { // gets a Player's number and returns it
        return playerNum; // playerNum is of type int
    }

    public LinkedList<Card> getHand() { // gets a Player's hand and returns it
        return hand; // hand is of type LinkedList<Card>
    }

    public String getPattern() { // gets a Player's pattern and returns it
        return pattern; // pattern is of type String
    }

    public String toString() { // a public method named toString() that prints Player details
        String s = ""; // String s is assigned to an empty String
        s += "Player Number: " + playerNum + "\n";
        s += "Pattern: " + pattern + "\n";
        s += "Current Hand of Cards: " + hand + "\n";
        // playerNum, pattern, and hand are concatenated to String s with newlines
        return s; // s is returned
    }

}
