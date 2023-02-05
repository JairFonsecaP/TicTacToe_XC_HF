# Tic Tac Toe Game
A Java version of the Tic Tac Toe game, created by Ximena Carrillo and Jair Fonseca.

## Usage
### How Play
#### To Consider:
- This is a local game, which means players have to play on the same computer.
- Must play two players, no more, no less.
- Players will play passing the mouse back and forth.
- Only one player can play at a time.
- Players must choose different nicknames. 
#### To Start
- The players must type their nicknames and select the size of the board they want to play with. Then press the "Play" button.
- The Game shows the board, where you can see:
 - Round: Number of the actual round.
 - Date: Actual Date
 - Player X Nickname and its score.
 - Player O Nickname and its score.
 - Turn Panel: Indicate who has to do the next move.
 - Grid: Composed of buttons, according to the size selected on the first screen.
#### To Play
- The system choose which player plays first.
- The player who is indicated in the Turn Panel has to press an unmarked button on the grid. Automatically, the button is disabled and it is marked with a character.
##### Round Rules
- A player wins if they acquire three consecutive squares in a row, column, or diagonal line.
- A player loses if the other player wins.
- Both players draw if all squares have been played with no winner.
##### Game Rules
- A game finish when the players decide not to play again.
- A player wins a game if they have won more rounds than the other.
- A player loses a game if the other player wins.
- Both players draw if they won the same number of rounds.

#### Play again
- When a round has ended, the players should be able to play another round, continually.
- If the players decide not to play again, the game ends.

### See the history of players
- On the principal screen (first), press the "History" link.
- A new screen will be opened. You should be able to see information about all players:
  - Player Number: Unique ID of the player
  - Player Nickname
  - Games played
  - Games won
  - Games Lost
  - Games drew

## Adittional Features
### Logs
#### Player Object Log
- When a new game starts if the players are new, a new file is created. 
- Each time a game finishes the information of the player is updated according to the result of the game.
- The files are saved in the directory "Players/"
#### Game Log
- Each time a player clicks a button on the grid a new line is written on the log.
- The file is "Log.txt" and is located in the directory "Game/"

If you want, you can see our code on: https://github.com/ximenacarrillo/TicTacToe_XC_HF

## Author

-   [Ximena Carrillo](https://www.linkedin.com/in/ximenacarrillo/)
-   [Hector Fonseca](https://hectorfonseca.dev)
