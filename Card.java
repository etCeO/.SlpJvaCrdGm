public class Card { // initializes body for public class Card

    private int rank; // declares private integer rank
    // ranks include numbers 2-10 in addition to Jacks, Queens, Kings, and Aces

    private int suit; // declares private integer suit
    // suits include hearts, spades, clubs, and diamonds
    
    // declares constant integer representations for ranks
    // these can be called in the syntax Card.ACE when creating new cards
    public static final int JACK = 11; // jack is assigned to 11
    public static final int QUEEN = 12; // queen is assigned to 12
    public static final int KING = 13; // king is assigned to 13
    public static final int ACE = 14; // ace is assigned to 14
    
    // declares constant integer representations for suits
    // these can be called in the syntax Card.SPADES when creating new cards
    public static final int HEARTS = 0; // hearts are assigned to 0
    public static final int SPADES = 1; // spades are assigned to 1
    public static final int CLUBS = 2; // clubs are assigned to 2
    public static final int DIAMONDS = 3; // diamonds are assigned to 3

    public Card() { // default constructor for class Card
        // the default card in this game is the ACE of SPADES
        rank = 14; // sets rank equal to 14 = ACE
        suit = 1; // sets suit equal to 1 = SPADES
    }

    public Card(int r, int s) { // overloaded constructor for class Card
        // takes 2 integer parameters r and s for rank and suit and puts them into Card format
        if (r > 1 && r < 15) { // if r is between 2 and 14
            rank = r; // parameter r is assigned with rank
        }
        if (s >= 0 && s <= 3) { // if s is between 0 and 3
            suit = s; // parameter s is assgined with suit
        }
    }

    public Card(Card c) { // copy constructor for class Card
        // takes parameter c of type Card and copies its contents as a new Card
        rank = c.rank; // copies rank of Card c
        suit = c.suit; // copies suit of Card c
    }

    public int getRank() { // a public method that gets the rank of a Card
        return rank; // returns rank as type int
    }

    public int getSuit() { // a public method that gets the suit of a Card
        return suit; // returns suit as type int
    }

    public void setRank(int r) { // a public void method that sets the rank of a Card
        // takes in parameter r as the rank to be assigned
        rank = r; // assigns int r as the new rank
    }

    public void setSuit(int s) { // a public void method that sets the suit of a Card
        // takes in parameter s as the suit to be assigned
        suit = s; // assigns int s as the new suit
    }

    public String toString() { // a public method that displays the contents of a Card as a String
        String s = ""; // creates a blank String s to store the full string
        String strRank = ""; // creates a blank String strRank for the rank naming
        String strSuit = ""; // creates a blank String strSuit for the suit naming
        switch (rank) { // initiates a switch statement to evaluate the value of rank
            case 11: // case rank is 11
                strRank = "JACK"; // rank is JACK
                break;
            case 12: // case rank is 12
                strRank = "QUEEN"; // rank is QUEEN
                break;
            case 13: // case rank is 13
                strRank = "KING"; // rank is KING
                break;
            case 14: // case rank is 14
                strRank = "ACE"; // rank is ACE
                break;
            default: // case where rank is any other number
                strRank = Integer.toString(rank); // strRank is assigned to the String version of rank
                break;
            // break statements included at the end to prevent confusion and continuous looping
        }
        switch (suit) { // initializes a switch statement to evaluate the value of suit
            case 0: // case suit is 0
                strSuit = "HEARTS"; // suit is HEARTS
                break;
            case 1: // case suit is 1
                strSuit = "SPADES"; // suit is SPADES
                break;
            case 2: // case suit is 2
                strSuit = "CLUBS"; // suit is CLUBS
                break;
            case 3: // case suit is 3
                strSuit = "DIAMONDS"; // suit is DIAMONDS
                break;
             // break statements included at the end to prevent confusion and continuous looping
        }
        s += strRank + " OF " + strSuit;
        // adds card details to String s in the form of "Card: RANK OF SUIT" (ex: Card: ACE OF SPADES)
        return s; // returns String s with card details
    }

    public boolean equals(Object o) { // public boolean method equals that compares 2 cards
        // returns a true/false value evaluating if the cards are equal or not
        // parameter o is of type Object and takes in an object from a class
        if (this == o) { // if memory addresses are the same
            return true; // both Cards are the same
        }    
        if (! (o instanceof Card)) { // if the object is not in class Card
            return false; // the two Cards are NOT the same
        }    
        Card c = (Card) o; // typecasts o as type Card
        return this.rank == c.rank; // compares rank values of both Cards as type int
        // if ranks are the same, the Cards are equal, so return true
        // otherwise return false
    }

}
