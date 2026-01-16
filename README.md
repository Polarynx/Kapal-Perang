# Kapal-Perang (Java)

## Overview
Kapal Perang is a console-based implementation of the classic Battleship game, developed in Java using object-oriented programming principles. The game allows a human player to compete against a computer-controlled opponent, featuring ship placement validation, turn-based combat, hit/miss detection, and persistent game result logging.

This project demonstrates core Java skills including class design, file I/O, arrays, control flow, and interactive user input.

## File Descriptions
- `Battlemain.java`
  - Entry point of the program
  - Runs the Game
  - Reads previous game results from `line.dat`
  - Appends the current game outcome (win/loss) to the file
- `Game.java`
  - Implements all gameplay mechanics:
    - Board initialization for player and bot
    - Ship placeent with boundaries
    - Turn-based shooting
    - Hit, miss, and repeat-hit detection
    - Win condition checks
  - Manages user interaction through the console
- `Location.java`
  - Represents a coordinate on the game board
  - Stores row and column values
  - Used for ship placement and shot targeting
  - Encapsulates grid logic cleanly for reuse
- `line.dat`
  - Stores a log of game results
  - Auto-updated after each completed game
## How to Run (Eclipse IDE)
  - Prereqs:
    - Java JDK >=8
    - Eclipse IDE (Java Developers edition rec)
  - Steps
      1. Open Eclipse
      2. Select File -> New -> Java Project
      3. Name the Project: KapalPerang
      4. Inside src/, add:
      - `Battlemain.java`
      - `Game.java`
      - `Location.java`
    5. Place `line.dat` in the project root directory
    6. Run  `Battlemain.java`

## Gameplay Instructions
- You'll be prompted to place ships by entering:
  - Entering coordinates (row, column)
  - Direction (1 = Up, 2 = Right, 3 = Down, 4 = Left)
- During combat:
  - Enter coordinates to target opponent's ship
  - Computer target your ship
- Game end when one of the sides' ships are destroyed.
