# Tic-Tac-Toe with AI

## About ℹ️
Everybody remembers this paper-and-pencil game from childhood: 
Tic-Tac-Toe, also known as Noughts and crosses or Xs and Os. 
A single mistake usually costs you the game, but thankfully it 
is simple enough that most players discover the best strategy quickly. 

So one day I thought to myself, let’s program Tic-Tac-Toe and get playing!

## All You Need To Know About The Project 📖
- There are 3 levels of AI: Easy, Medium, Hard
  - Easy AI, makes the moves randomly
  - Medium AI, if it already has two in a row and can win with one further move, it does so.
      If its opponent can win with one move, it plays the move necessary to block this.
      Otherwise, it makes a random move.
  - Hard AI, uses MiniMax algorithm so there is no way to beat it.
- You can either play against any AI of your choice or watch two AI-s play together.
- This is a command line project.
- Run Main.java file to start it.

## I want to play! What shoud I do? 🎮
Input the command start. It takes two parameters: who will play `X` 
and who will play `O`. Following options are possible
1. Play against AI
2. Two AIs to play against each other.

### For example: 🛝

- `start user easy` means that user is playing against AI of level easy. 
Where user is playing as `X` and AI is playing as `O`

- `start hard medium` means that Hard AI (`X`) is playing against Medium AI (`O`).

When playing you will be asked to input coordinates. Grid has the following coordinates for cells:

```
---------------------------
| (1, 1) | (1, 2) | (1, 3)|
| (2, 1) | (2, 2) | (2, 3)|
| (3, 1) | (3, 2) | (3, 3)|
---------------------------
```
Enter the coordinates of your move seperated by space like this: `2, 3`

## To Exit The Program 🚪
To exit the program type `exit` after the current game is finished.



