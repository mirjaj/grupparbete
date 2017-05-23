## Project description:
 We have created a trivia game that is based on a board game called Geni.
 The game has the following features:
 * Have 3 NPC that plays against the user. 
 * A main menu.
 * The difficulties easy, medium and hard.  
 * Questions based on different categories.
 * A graphical visualization of the board game.
 * Be able to answer questions by choosing between different checkboxes. 
 * A score limit. 
 * A textbox that displays the users and the NPC:s actions. 
 
 We have tested our code using unit test while developing our game. Also we have test runned the game multiple times to see if it has any bugs. 
 
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

After cloning into the repo you run the program from the src folder. The images are here as well, and the program will find them.

No extention libraries are required, since Java FX is a standard library. The player
needs to have all the assosciated classes in order to play the game. 

These required classes are:
* Main.java
* Gameboard.java
* Player.java
* Question.java
* MenuButtons.java
