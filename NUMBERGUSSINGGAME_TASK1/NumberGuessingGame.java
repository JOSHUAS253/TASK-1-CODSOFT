/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numberguessingame;

/**
 *
 * @author JOSHUA S
 */
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 7;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!\n");
        boolean keepPlaying = true;

        while (keepPlaying) {
            int secretNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            System.out.printf("Round - Guess a number between %d and %d\n", MIN_RANGE, MAX_RANGE);
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.\n");

            int attempts = 0;
            boolean isGuessed = false;

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                attempts++;

                if (guess == secretNumber) {
                    System.out.printf("Congratulations! You've guessed the number in %d attempts.\n", attempts);
                    totalScore += attempts;
                    isGuessed = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low! Try again.\n");
                } else {
                    System.out.println("Your guess is too high! Try again.\n");
                }
            }

            if (!isGuessed) {
                System.out.println("Out of attempts! The correct number was " + secretNumber);
            }

            System.out.println("Your current total score: " + totalScore + "\n");

            System.out.print("Would you like to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing! Your final score: " + totalScore);

        scanner.close();
    }
}

