import java.util.Scanner;
public class RockPaperScissors {

    public static void main(String [] args){
        // Initializing all the classes and variables used
        Scanner userInput = new Scanner(System.in);
        int tie = 0;
        int computerWin = 0;
        int userWin = 0;
        boolean playAgain = false;

        // Scanner for user input
        while (true) {
            System.out.println("Please enter the number of rounds you want to play (1 - 10):  ");
            int rounds = userInput.nextInt();
            System.out.println("You have selected to play " + rounds + " rounds");

            // if statement for checking correct number of rounds
            if (rounds > 10 || rounds < 1) {
                System.out.println("Please try again and make sure the number is between 1 to 10 ");
                break;
            } else {
                // Play multiple rounds
                for (int i = 0; i < rounds; i++) {
                    // Ask user for RPS selection
                    System.out.println(" ");
                    System.out.println("Choose between Rock, Paper and Scissors  ");
                    System.out.println("Enter 1 for Rock");
                    System.out.println("Enter 2 for Paper");
                    System.out.println("Enter 3 for Scissors");
                    int userSelection = userInput.nextInt();
                    System.out.println(" ");
                    System.out.println("You have selected " + userSelection);

                    // Computer randomly chooses
                    int computerSelection = (int) (Math.random() * 3) + 1;
                    System.out.println("The computer has selected " + computerSelection);

                    // Calculate who won the round

                    if (userSelection == computerSelection) {
                        tie++;
                        System.out.println("It's a tie ");
                    } else if (userSelection == 1 && computerSelection == 3
                            || userSelection == 2 && computerSelection == 1
                            || userSelection == 3 && computerSelection == 2) {
                        userWin++;
                        System.out.println("You won this round ");
                    } else {
                        computerWin++;
                        System.out.println("The computer won this round ");
                    }
                    // Print results
                    System.out.println(" ");
                    System.out.println("Computer score is: " + computerWin);
                    System.out.println("User score is: " + userWin);
                    System.out.println("Tie score: is " + tie);
                } // end of for loop (rounds <= 10)
            } // end of multiple rounds

            // Check overall winner
            if (computerWin > userWin) {
                System.out.println("Computer won this game ");
            } else if (userWin > computerWin) {
                System.out.println("Congrats! You won this game ");
            } else {
                System.out.println("It's a tie overall, Play again!");
            } // end of check overall winner

            // Check if user would like to play again
            System.out.println(" ");
            System.out.println("Would you like to play again? Yes or No: ");
            String userPlayAgain = userInput.next();

            if (userPlayAgain.equals("No")) {
                playAgain = false;
                System.out.println("Thanks for playing, see you later!");
                break;
            } else {
                playAgain = true;
            } // end of asking user to play again
        } // end of play again while loop

    } // end of main method
} // end of main class