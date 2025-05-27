import java.util.LinkedList; // imports LinkedList from java
import java.util.Random; // imports Random from java

public class Game { // initializes the body structure of public class Game

    private LinkedList<Player> players; // a private LinkedList for players that stores all the game's players
    private LinkedList<Card> pile; // a private LinkedList pile that stores all the player's drawed cards
    private Dealer dealer; // a private Dealer type that deals the cards in the Deck to each player
    private String[] patterns; // a private array of type String where all types of patterns are stored
    private boolean faceSuccess; // a private boolean faceSuccess that tells if a player succeeds in a faceOff or not
    private int currentPlayer; // a private int currentPlayer representing the index of the Player in the LinkedList

    public Game() { // default constructor that forms a Game of 2 Players
        patterns = buildPatterns(); // private method buildPatterns is called to display all patterns
        players = new LinkedList<>(); // LinkedList players is created
        Random rand = new Random(); // new random method is called
        dealer = new Dealer(); // dealer is called to establish a new Deck of 52 cards
        LinkedList<Card> pl = new LinkedList<>(); // a LinkedList named pl is created to store each Player's hand
        for (int k = 1; k <= 2; k++) { // for each of the 2 players
            pl = dealer.deals(26); // deal 26 random Cards (half) from the Deck
            Player a = new Player(k, pl, patterns[rand.nextInt(3)]); // a new Player is created using an overloaded constructor
            // int k is assigned to the Player's num
            // pl is assigned to the Player's hand of Cards
            // a random pattern from the pattern's array is assigned to the Player's pattern
            players.add(a); // the 2 Player's are added to the players list
        }
        pile = new LinkedList<>(); // pile is initialized as a blank LinkedList
    }

    public Game(int p) { // an overloaded constructor for Game that takes in the number of Players
        patterns = buildPatterns(); // private method buildPatterns is called to display all patterns
        players = new LinkedList<>(); // LinkedList players is created
        Random rand = new Random(); // new random method is called
        dealer = new Dealer(); // dealer is called to establish a new Deck of 52 cards
        LinkedList<Card> pl = new LinkedList<>(); // a LinkedList named pl is created to store each Player's hand
        int j = 52 / p; // integer j is assigned to a whole number that distributes the Deck equally amongst the Players
        // this means no single Player will have a greater amount of cards than the others
        for (int k = 1; k <= p; k++) { // for all players of int p
            pl = dealer.deals(j); // deal j amount of random cards
            Player a = new Player(k, pl, patterns[rand.nextInt(3)]); // a new Player is created using an overloaded constructor
            // int k is assigned to the Player's num
            // pl is assigned to the Player's hand of Cards
            // a random pattern from the pattern's array is assigned to the Player's pattern
            players.add(a);
        }
        pile = new LinkedList<>(); // pile is initialized as a blank LinkedList
    }

    public int play() { // a public method play that implements the rules of the game until there is only one Player standing
        // the final Player who is not eliminated becomes the Winner of the game and has their number returned to them
        currentPlayer = 0; // initiates currentPlayer index to 0
        Player p; // initializes the existence of p as type Player
        p = players.get(currentPlayer); // p is assigned to the first Player in the players LinkedList
        while (players.size() > 1){ // while there are more than 2 Players remaining in the Game
            if (players.size() < 2){ break;} // if there are less than 2 Players, break
            // this is not a valid game to play
            if (p.getHand().size() == (52 - dealer.size())) { // if a player's hand has all cards distributed 
                p = priorPlayer(); // p is assigned to the other non-existant player in the game
                players.remove(p); // that player with 0 cards is removed
            }
            if (p.getHand().size() > (52 - dealer.size())){ players.remove(p);} 
            // if a Player's hand is greater than the Deck of Cards minus the remainder not dealt
            // this Player has surpassed the limits of the Game and should not be playing
            if (p.getHand().size() > 0) { // if a Player's hand size is at least 1
                Card a = p.playCard(); // Card a is assigned to the Card played by Player p
                System.out.println("Player " + p.getPlayerNum() + " puts down the " + a);
                // prints the Card that was played by which Player
                pile.add(a); // Card a is added to the pile LinkedList
                int j = pile.size() - 1; // int j is the index of the last card in pile
                System.out.println("Pile Size: " + pile.size()); // prints the pile size to keep track of card count

                // some original code I thought about for patterns, but this kept generating an illegal bound
                //for (Player b : players) {
                    //if (b.slaps(pile)) { // if the slaps boolean for pile is true
                        //System.out.println("There's a pattern recognized here!");
                        // print that a pattern is recongized here
                        //addHand(b); // addHand private method is called with Player p
                        //p = b;
                        //System.out.println("    Player " + p.getPlayerNum() + " hand size: " + p.getHand().size());
                        // prints the hand size of Player
                        //System.out.println("Player " + p.getPlayerNum() + " starts the next round...");
                        // tells us which Player starts the next round
                        //break;
                    //}    
                //}

                if (pile.get(j).getRank() > 10) { // if the ranking of the last card is greater than 10
                    // a faceOff is initiated
                    System.out.println("Player " + p.getPlayerNum() + " has initiated a FACEOFF!");
                    // prints which player initiated the faceOff
                    faceOff(j, p); // faceOff private method is called with Player p and index j
                    System.out.println("    Player " + p.getPlayerNum() + " hand size: " + p.getHand().size());
                    // prints the hand size of Player          
                }
                else if (p.slaps(pile)) { // if the slaps boolean for pile is true
                    System.out.println("There's a pattern recognized here!");
                    // print that a pattern is recongized here
                    addHand(p); // addHand private method is called with Player p
                    System.out.println("    Player " + p.getPlayerNum() + " hand size: " + p.getHand().size());
                    // prints the hand size of Player
                    System.out.println("Player " + p.getPlayerNum() + " starts the next round...");
                    // tells us which Player starts the next round
                }    
                else { // if there's no faceOff or pattern
                    System.out.println("    Player " + p.getPlayerNum() + " hand size: " + p.getHand().size());
                    // print the hand size of Player p
                    p = nextPlayer();
                    // move on to the next Player
                }
                if (players.size() < 2){ break;} // if there are less than 2 Players, break
                if (p.getHand().size() > (52 - dealer.size())){ players.remove(p);} 
                    // if a Player's hand is greater than the Deck of Cards minus the remainder not dealt
                    // this Player has surpassed the limits of the Game and should not be playing
            }
            else { // if a player's hand size is 0
                System.out.println("    Player " + p.getPlayerNum() + " hand size: " + p.getHand().size());
                // print their current hand size to be 0
                System.out.println("Player " + p.getPlayerNum() + " is out the game!!!!!!!");
                // tell them that they are out of the game
                Player b = nextPlayer(); // for more than 2 players, player b is assigned to the next player in the game
                players.remove(p); // old Player p is removed
                p = b; // p is now moving on to the next player
            }
        }
        System.out.println("THE GAME HAS ENDED!!!"); // prints the ending of the game
        return players.get(0).getPlayerNum(); // returns the index of the only player left in players LinkedList
    }

    private Player nextPlayer() { // a private method that returns the Player object of the next player in the circle
        // used for taking turns and determining faceOff players
        if (currentPlayer < players.size() - 1) { // if currentPlayer index is less than the last index of players
            currentPlayer += 1; // add one to currentPlayer
            return players.get(currentPlayer); // return the player at currentPlayer
        }
        else { // if currentPlayer is equal to the last index of players
            currentPlayer = 0; // currentPlayer is assigned to 0, or Player 1
            return players.get(currentPlayer);
        } // return the player at currentPlayer
    }

    private Player priorPlayer() { // a private method that returns the Player object of the previous player in the circle
        if (currentPlayer > 0) { // if index currentPlayer is greater than 0
            currentPlayer -= 1; // decrease the index by 1 to get the previous player in players
            return players.get(currentPlayer); // return the player at currentPlayer
        }
        else { // if currentPlayer is at index 0
            currentPlayer = players.size() - 1; // assign currentPlayer to the last index of players list
            return players.get(currentPlayer); // return the player at currentPlayer
        }
    }

    static boolean topBottom(LinkedList<Card> pile) { // a static method for topBottom in Game
        // returns a boolean evaluating if a topBottom combo is valid in the current pile
        if (pile.size() > 3) { // if the size of a pile is greater than 3
            // this means a topBottom pattern is possible
            int i = pile.size() - 1; // int i is assigned with the last card index in the pile
            return pile.get(0).equals(pile.get(i)); // returns a boolean comparing two cards
            // if the card at the top of the pile is the same rank as the card at the bottom of the pile, this returns true
            // else this returns false
        }
        else { // if the pile size is less than 4
            return false; // a topBottom pattern cannot exist
        }  
    }

    static boolean doubles(LinkedList<Card> pile) { // a static method for doubles in Game
        // returns a boolean evaluating if a doubles combo is valid in the current pile
        if (pile.size() > 1) { // if the size of a pile is greater than 1
            // this means a doubles pattern is possible
            int i = pile.size() - 1; // int i is assigned with the last card index in the pile
            int j = pile.size() - 2; // int j is assigned to the card before i
            return pile.get(j).equals(pile.get(i)); // returns a boolean comparing two cards
            // if the card at the top of the pile is the same rank as the card played before, this returns true
            // else this returns false
        }
        else { // if the pile size is less than 2
            return false; // a doubles pattern cannot exist
        }
    }

    static boolean sandwich(LinkedList<Card> pile) { // a static method for sandwich in Game
        // returns a boolean evaluating if a sandwich combo is valid in the current pile
        if (pile.size() > 2) { // if the size of a pile is greater than 2
            // this means a sandwich pattern is possible
            int i = pile.size() - 1; // int i is assigned with the last card index in the pile
            int j = pile.size() - 3; // int j is assigned to the card before the previous card played
            return pile.get(j).equals(pile.get(i)); // returns a boolean comparing two cards
            // if the card at the top of the pile is the same rank as 2nd before last card, this returns true
            // else this returns false
        }
        else { // if the pile size is less than 3
            return false; // a sandwich pattern cannot exist
        }
    }

    public LinkedList<Player> getPlayers() { // an accessor method that gets the LinkedList of Players
        return players; // returns the players member variable
    }

    public LinkedList<Card> getPile() { // an accessor method that gets the LinkedList of cards in the pile
        return pile; // returns the pile member variable
    }

    public Dealer getDealer() { // an accessor method that gets the dealer
        return dealer; // returns the dealer member variable
    }

    public int getCurrentPlayer() { // an accessor method that gets the currentPlayer index
        return currentPlayer; // returns the currentPlayer member variable
    }

    public boolean getfaceSuccess() { // an accessor method that gets status of a faceSuccess
        return faceSuccess; // returns the faceSuccess member variable
    }

    private String[] buildPatterns() { // a private method that builds all patterns and puts them in a String array
        patterns = new String[3]; // creates an empty array of size 3
        patterns[0] = "doubles"; // assigns "doubles" pattern to index 0
        patterns[1] = "topBottom"; // assigns "topBottom" pattern to index 1
        patterns[2] = "sandwich"; // assigns "sandwich" pattern to index 2
        return patterns; // returns the String array of all patterns
    }

    private void faceOff(int cardIndex, Player p) { // a private void method called faceOff that keeps track of a faceOff play
        // parameter cardIndex is the index of the face Card in pile
        int r = pile.get(cardIndex).getRank() - 10; // int r is assigned to the rank of Card minus 10
        // this formula calculates the number of chances the next player has to play a face Card
        p = nextPlayer(); // player p is assigned to the nextPlayer
        System.out.println("Player " + p.getPlayerNum() + " now has " + r + " chance(s) to play a face card!");
        // prints numbers of chances for p
        if (p.getHand().size() < r) {
            for (int i = 0; i < p.getHand().size(); i++) {
                Card c = p.playCard(); // Card c is assigned to player's drawed card
                System.out.println("Player " + p.getPlayerNum() + " puts down the " + c);
                // prints the value of Card c
                pile.add(c); // adds c to the center pile
                if (c.getRank() > 10) { // if the rank of c is greater than 10
                    System.out.println("Player " + p.getPlayerNum() + " has succeeded putting down a face card!");
                    // this means the player has succeeded in the faceOff
                    p = nextPlayer(); // p is assigned to the next player
                    System.out.println("Moving on to Player " + p.getPlayerNum()); // next player's number is printed
                    faceSuccess = true; // faceSuccess boolean is assigned with true  
                    break; // exits loop
                }
                faceSuccess = false; // faceSuccess boolean is assigned with false if the player is unsuccessful    
            }
        }
        else {
            for (int i = 0; i < r; i++) { // for every chance player p gets
                Card c = p.playCard(); // Card c is assigned to player's drawed card
                System.out.println("Player " + p.getPlayerNum() + " puts down the " + c);
                // prints the value of Card c
                pile.add(c); // adds c to the center pile
                if (c.getRank() > 10) { // if the rank of c is greater than 10
                    System.out.println("Player " + p.getPlayerNum() + " has succeeded putting down a face card!");
                    // this means the player has succeeded in the faceOff
                    p = nextPlayer(); // p is assigned to the next player
                    System.out.println("Moving on to Player " + p.getPlayerNum()); // next player's number is printed
                    faceSuccess = true; // faceSuccess boolean is assigned with true  
                    break; // exits loop
                }
                faceSuccess = false; // faceSuccess boolean is assigned with false if the player is unsuccessful
            }
        }
        if (faceSuccess == false) { // if the player fails
            System.out.println("Player " + p.getPlayerNum() + " has failed to put down a face card :(");
            // print the failure
            p = priorPlayer(); // assign p to the player who put down the face Card previous
            System.out.println("Player " + p.getPlayerNum() + " now collects all the cards!!!");
            // say that player collects the center pile
            for (int i = 0; i < pile.size(); i++) { // for all cards in the pile
                p.getHand().add(pile.get(i)); // add each card in pile to the player's hand
            }
            pile.clear(); // clear the pile after because it is empty
            System.out.println("Player " + p.getPlayerNum() + " now puts down the next card...");
            // tells us which player goes next
        }
    }


    private void addHand(Player p) { // a private void method that adds cards from pile to Player p
        // this is called specifically when a pattern is recognized in pile and a player can slap
        Random r = new Random(); // r is assigned to a new random
        p = players.get(r.nextInt(players.size())); // a random player is chosen from players and assigned to p
        while (p.slaps(pile) == false) { // while player p cannot slap the pile
            p = players.get(r.nextInt((players.size()))); // p is assigned to a random player
        }
        System.out.println("Player " + p.getPlayerNum() + " slaps the pattern!!!!");
        // tells which player slaps the pattern
        if (p.getPattern().equals("topBottom")) { // if the pattern is a topBottom
            for (int i = 0; i < pile.size(); i++) { // for every card in the pile
                p.getHand().add(pile.get(i)); // add it to the player's hand
            }
            pile.clear(); // clear the pile since its empty
            System.out.println("The topBottom is added to Player " + p.getPlayerNum() + "'s cards :)");
            // prints that a topBottom has been added
        }
        if (p.getPattern().equals("doubles")) { // if the pattern is a doubles
            for (int i = pile.size() - 2; i < pile.size(); i++) { // for the last two cards in the pile
                p.getHand().add(pile.get(i)); // add them to the player's hand
                pile.remove(i); // remove the two cards from the pile
            } 
            System.out.println("The doubles are added to Player " + p.getPlayerNum() + "'s cards :)");
            // prints that a doubles has been added
        }
        if (p.getPattern().equals("sandwich")) { // if the pattern is sandwich
            for (int i = pile.size() - 3; i < pile.size(); i++) { // for the last three cards in the pile
                p.getHand().add(pile.get(i)); // add them to the player's hand
                pile.remove(i); // remove the three cards from the pile
            } 
            System.out.println("The sandwich is added to Player " + p.getPlayerNum() + "'s cards :)"); 
            // prints that a sandwich has been added
        }
    }
}
