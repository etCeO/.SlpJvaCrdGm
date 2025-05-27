public class Driver { // establishes the body of Driver class

    public static void main(String[] args) { // creates a main method
        
        Game a = new Game(); // creates a default game of 2 players using the Game class
        System.out.println(a.getPlayers()); // prints each player's details
        System.out.println("Pile: " + a.getPile()); // gets the current pile and prints its cards
        // since the game hasn't started yet, the pile should be empty
        System.out.println("Dealer: " + a.getDealer()); // gets the dealer variable from game a
        // since all cards from Game a are dealt, this should also be empty

        a.play(); // iniates the play method for Game a
        // I would have printed this to return the Player num, but I thought it easier to just get the remaining player in players
        System.out.println("FINAL WINNER"); // print statements for neatness and spacing
        System.out.println("------------");
        System.out.println(a.getPlayers()); // prints the contents of the winner, including their number, pattern, and current hand of cards
        System.out.println("Pile: " + a.getPile()); // prints whatever cards are left in the pile

        // as elaborated before in my README, my Game is not fully equipped to operate for more than 2 players
        // you're more than welcome to uncomment these next lines of code out if you want and test this error
        // however, you'll see the order of the players in a few parts of the Game is not going to make any sense

        //Game b = new Game(5); // creates a default game of 5 players using the Game class
        //System.out.println(b.getPlayers()); // prints each player's details
        //System.out.println("Pile: " + b.getPile()); // gets the current pile and prints its cards
        //// since the game hasn't started yet, the pile should be empty
        //System.out.println("Dealer: " + b.getDealer()); // gets the dealer variable from game b
        //// since 10 cards each from Game b are dealt, this should hold 2 remaining cards that are not used

        //b.play(); // iniates the play method for Game b
        //// I would have printed this to return the Player num, but I thought it easier to just get the remaining player in players
        //System.out.println("FINAL WINNER"); // print statements for neatness and spacing
        //System.out.println("------------");
        //System.out.println(b.getPlayers()); // prints the contents of the winner, including their number, pattern, and current hand of cards
        //System.out.println("Pile: " + b.getPile()); // prints whatever cards are left in the pile

    }

}
