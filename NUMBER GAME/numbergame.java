import java.util.Scanner;

public class numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minNumber = 1;
        int maxNumber = 100;

        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            // Generate a random number
            int randomNumber = (int) (Math.random() * (maxNumber - minNumber + 1)) + minNumber;

            // Set the number of attempts allowed
            int attempts = 5;

            boolean guessedCorrectly = false;

            // Main game loop
            while (attempts > 0 && !guessedCorrectly) {
                System.out.println("Guess a number between " + minNumber + " and " + maxNumber + ". Attempts remaining: " + attempts);
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    int score = calculateScore(attempts);
                    totalScore += score;
                    System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts. Score: " + score);
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Guess again.");
                    attempts--;
                } else {
                    System.out.println("Too high. Guess again.");
                    attempts--;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts. The number was: " + randomNumber);
            }

            // Ask the user if they want to play again
            System.out.println("Do you want to play again? (y/n)");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("y");
        }

        scanner.close();

        System.out.println("Thank you for playing! Your total score is: " + totalScore);
    }

    public static int calculateScore(int attempts) {
        // Higher attempts result in lower score (maximum score is attempts)
        return attempts;
    }
}
