# SlapJack Card Game

- A simulation of the classic Slap card game that models core gameplay mechanics, evaluating multiple card combinations—such as rank pairs and face cards—to accurately determine valid slaps and game outcomes.

## Author Info

- Full Name: Ethan E. Lopez
- Student ID: 2425516
- Chapman Email: etlopez@chapman.edu
- Course Number And Section: CPSC-231-01
- Assignment Or Exercise Number: MP 3: Card Game

## Usage

- Compile the program using the appropriate compiler for the programming language used.
- Run the executable to start the game simulation.
- The program executes the game logic automatically (or through user interaction, depending on implementation) and displays the results of each turn and slap evaluation.

## Input Format

- The program uses a standard 52-card deck.
- Cards are represented by rank and suit, either internally or via a predefined input structure.
- If user input is required, players interact through console prompts to perform actions such as slapping or advancing turns.
- All gameplay rules follow traditional SlapJack conventions.

## Implementation Details

- The program models cards, decks, and players using object-oriented principles.
- Game logic evaluates slap conditions, including:
1. Rank pairs
2. Face cards (Jack, Queen, King)
3. Other defined valid slap combinations
- A control loop manages turn progression, slap detection, and card pile updates.
- The simulation determines game termination conditions and declares a winner based on remaining cards or successful slaps.
