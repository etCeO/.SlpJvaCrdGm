# SlapJack Card Game

- A simulation of the classic Slap card game that models core gameplay mechanics, evaluating multiple card combinations such as rank pairs and face cards to accurately determine valid slaps and game outcomes.

## Author Info

- Full Name: Ethan E. Lopez
- Chapman Email: etlopez@chapman.edu

## Usage

1. Compile program using compiler statements suitable for Java.
2. Run the executable to begin the game simulation.
3. The program executes the game logic automatically and shows the results of each turn and slap calculation.

## Input Format

- The program uses a standard deck of 52 cards.
- Cards consist of a rank and suit, implemented either internally or specified through a predefined input structure.
- In case user input is required, players interact through console prompts while actions like slapping are executed.
- All game rules follow the conventional SlapJack movements.

## Implementation Details

- The program uses object-based concepts to model cards, decks, and players.
- Game logic evaluates slap conditions, such as:
1. Rank Pairs
2. Face Cards (Jack, Queen, King)
3. Other defined valid slap combinations
- A control loop is used for turn progression, slap detection, and card pile updating.
- The simulation defines the termination conditions of the games and the winner through the remaining cards or successful slaps.
