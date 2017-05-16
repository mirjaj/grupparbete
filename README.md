## Project description:
 We want to create a trivia game that is based on a board game called Geni.
 The game is planned to include following features:
 * Have up to 4 players/NPC:s that play simultaneously. 
 * Questions based on different categories.
 * A graphical visualization of the board game.
 * Be able to answer questions by choosing between different checkboxes and by writing. 
 
 Features will be added and/or deleted depending on how the project is going. 
 
 We are going to begin testing our code with unit tests while we are developing our game. 
 Later on we may find other ways to test the game. 
 
 #### How to play
The player is at first presented by a main menu, if the player wants to play the game the player can proceed by clicking "start game".

The player plays the game by clicking the button to roll a dice. The player then moves, 
and is to answer questions, mostly related to programming and mathmatics, but there is also a category for general questions. 

If the player answers a question correctly, her or she is awarded points.
The player who first reaches the required amount of points to win, wins the game.

The player plays against 3 computer players, or NPCs. These players will 
also attempt to win. If none of these players gets high enough score once all the questions are 
answered, no one is declared the winner. 

Worth to note is that if the player, or the computer, answers a question correctly, not only will they recieve points but
they will also get the oppertunity to play again. Basically, when player A answers incorrectly, the turn will proceed to
the player who was initially next to player A (clockwise).

The questions are structurized into six various categories, with five of them being questions
related to the Computer Scientist programme at KTH. The sixth category will involve general questions
which can be everything, as an example one such question is "How many times did Arnold win Mr Olympia?".

![The main menu](/Screenshots/mainMenuImage.png)
![The gameboard](/Screenshots/GameBoardImage.png)

#### Java FX
This game was created mainly using the framwork Java FX. All the buttons, images and graphical figures 
have been made using the Java FX framework.

Java FX is a set of packages that enables the user to program a GUI. If you want to read more about the
Java FX framework you can look it up here: 
[Java FX](http://docs.oracle.com/javafx/2/overview/jfxpub-overview.htm)

#### How to install
This game is run from the main class. That means that the player needs to
be able to run java programs in order to play the game. 

Also, it is worth to note that the player needs to have the background image which is in the main menu, 
stored in a specified path to run the program along with the other images used in the game.

No extention libraries are required though, since Java FX is a standard library. The player
needs to have all the assosciated classes in order to play the game. 

These required classes are:
* Main.java
* Gameboard.java
* Player.java
* Question.java
* MenuButtons.java
