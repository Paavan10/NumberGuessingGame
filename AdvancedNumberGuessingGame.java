import java.util.Random;
import java.util.Scanner;

public class AdvancedNumberGuessingGame {

    public static void main(String[] args) {
        // Authors: Naitik Joshi, Chirag Prajapati, Paavan Shastri

        // Create a random number generator, and generate a random number between 0 and 1000
        Random random = new Random();
        int secretNumber = random.nextInt(1001);

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to guess the number
        System.out.println("Welcome to the Advanced Number Guessing Game!");
        System.out.println("Try to guess the secret number between 0 and 1000.");

        // Variables to store the user's guess, the range, and the number of guesses
        int userGuess, minRange = 0, maxRange = 1000, numberOfGuesses = 0;
        final int maxAttempts = 10;
        final long timeLimitMillis = 60 * 1000; // 60 seconds * 1000 milliseconds

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Main game loop
        while (numberOfGuesses < maxAttempts) {
            // Check if the time limit has been exceeded
            if (System.currentTimeMillis() - startTime > timeLimitMillis) {
                System.out.println("Time's up! The game is over.");
                System.exit(0); // Terminate the program
            }

            // Increment the number of guesses
            numberOfGuesses++;

            // Display the current range
            System.out.println("Current range: [" + minRange + " - " + maxRange + "]");

            // Get the user's guess and validate it
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            if (userGuess < minRange || userGuess > maxRange) {
                System.out.println("Please guess within the current range.");
                continue;
            }

            // Check if the guess is correct, too low, or too high
            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + numberOfGuesses + " guesses.");
                System.exit(0); // Terminate the program
            } else {
                System.out.println((Math.abs(userGuess - secretNumber) <= 10) ? "Close, but not quite. Try again." :
                        (userGuess < secretNumber) ? "Too low! Try again." : "Too high! Try again.");

                // Adjust the range based on the user's guess
                minRange = (userGuess < secretNumber) ? userGuess + 1 : minRange;
                maxRange = (userGuess > secretNumber) ? userGuess - 1 : maxRange;
            }
        }

        // If the user couldn't guess the number within the allowed time, reveal the secret number
        if (numberOfGuesses == maxAttempts) {
            System.out.println("Sorry! You've reached the maximum number of attempts. The secret number was: " + secretNumber);
        }

        // Close the Scanner
        scanner.close();
    }
}