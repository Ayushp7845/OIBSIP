# OIBSIP
Oasis Infobyte Java Programming Internship Projects

# Number Guessing Game

This is a JavaFX application that implements a Number Guessing Game. In this game, the user has to guess a number randomly generated between 1 and 100 within a maximum of 10 attempts.

## How to Play

1. The game interface displays a title "NUMBER GUESSING GAME", a score, the number of attempts remaining, an information label, a text field, and a submit button.

2. Enter a number between 1 and 100 in the text field and click the submit button.

3. The game will provide feedback based on your guess:
   - If the guessed number is correct, the information label will display "Congratulations!! Your Guess [number] is correct", the score will be updated, and the attempts will be shown.
   - If the guessed number is lower than the random number, the information label will display "Guessed number < Number", and the attempts will be shown.
   - If the guessed number is higher than the random number, the information label will display "Guessed number > Number", and the attempts will be shown.
   - If an invalid input is provided (not a number or outside the valid range), the information label will display "Please enter a number between (1-100)", and the attempts will be shown.
   - If all attempts are exhausted without guessing the correct number, the information label will display "You're OUT OF ATTEMPTS :(", and the game will be reset.

4. After each guess, the text field will be cleared, allowing you to enter a new number.

## Program Structure

The program consists of the following classes and methods:

- **Game**: This class extends `javafx.application.Application` and serves as the entry point for the application. It contains the main method and defines the user interface using JavaFX components. It also handles the event when the submit button is clicked and calls the `check` method to evaluate the guess.

- **check**: This method takes the user's guess as input and determines the result of the guess. It compares the guess with the randomly generated number and updates the attempts variable accordingly. It returns an integer value representing the result of the guess.

- **resetGame**: This method resets the game by initializing the attempts, score, and generating a new random number.

## Getting Started

To run the Number Guessing Game, perform the following steps:

1. Ensure you have Java Development Kit (JDK) installed on your system.

2. Compile the Java source file using the following command:
javac com/example/number_guessing_game/Game.java

3. Run the compiled class using the following command:
java com.example.number_guessing_game.Game

4. The Number Guessing Game window will open, and you can start playing the game by following the instructions provided on the interface.

Note: This program requires JavaFX to be installed on your system. Make sure you have the necessary dependencies and configurations in place to run JavaFX applications.


## Acknowledgments

This program is a simple implementation of a Number Guessing Game and does not involve any external libraries or complex algorithms. It serves as a learning exercise and can be further enhanced and customized based on individual requirements.


