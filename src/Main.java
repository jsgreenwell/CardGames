import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Add games here to have people choose
        final String[] games = {"BlackJack", "GoFish", "UNO"};

        Scanner scan = new Scanner(System.in);

        System.out.println("Which game do you wish to play?");
        for (int i=0; i<=games.length; i++) {
            if (i == games.length) {
                // out of games - print exit choice
                System.out.printf("\t%d: To Exit", i);
            } else {
                // or print the choice number & game
                System.out.printf("\t%d: %s", i, games[i]);
            }
        }

        System.out.print("Please enter number to select a game");
        int gameChoice = Integer.parseInt(scan.nextLine());
        switch (gameChoice) {
            case 0:
                playBlackJack();
                break;
            case 1:
                playGoFish();
                break;
            case 2:
                playUNO();
                break;
            default:
                System.out.println("Thank you for playing!");
                System.exit(0);
        }
    }

    /**
     * This is the entire GoFish Engine right now.
     * Would make it a full class once I start the AI logic
     */
    private static void playGoFish() {
        // Now for the go fish - maybe it will be simpler
        // Added player logic - will add dealer (AI) logic later
        Scanner fishScan = new Scanner(System.in);
        GoFish fish = new GoFish();
        System.out.println(fish.dealerHand.toString());

        System.out.println(fish.showPlayersHand());
        System.out.print("""

                \t\tRemember you must search for a face in hand
                \t\tOur else you'll have to 'Go Fish'
                What card do you want to search for? (face)""");
        if (fish.checkHand("player", fishScan.nextLine())) {
            System.out.println("Other player has a match! Your hand is now: ");
            System.out.println(fish.showPlayersHand());
        } else {
            System.out.printf("No match - you go fish and get a %s ",
                    fish.fishing("player"));
        }
    }

    /**
     * BlackJack Logic - need to split into Engine because it Includes AI
     */
    private static void playBlackJack() {
        /* BlackJack code answers */
        Scanner scanner = new Scanner(System.in);
        BlackJack blackjack = new BlackJack();

        // You'll need a regular if here not switch - why?
        if (blackjack.getHandTotal("dealer") == 21) {
            // check if dealer wins and exit if true
            System.out.println("You Lose!!! Dealer has 21 - bye bye.");
            System.exit(0);
        }

        // create main game loop here
        String turn = "player";

        while(true) {
            System.out.println("The Dealer has:");
            System.out.println(blackjack.getHand("dealer"));
            System.out.println("The Player has:");
            System.out.println(blackjack.getHand("player"));

            switch (turn) {
                case "player":
                    if (blackjack.getHandTotal("player") == 21) {
                        System.out.println("You won or got a draw! Let's find out!");
                        turn = "dealer";
                    } else if (blackjack.getHandTotal("player") <= 20) {
                        System.out.print("Do you want to hit? (yes/no)");
                        if (scanner.nextLine().toLowerCase().startsWith("yes")) {
                            blackjack.drawCard("player");
                        } else {
                            System.out.print("Do you want to stay? (yes/no)");
                            if (scanner.nextLine().toLowerCase().startsWith("yes")) {
                                System.out.printf("Alright staying with %d\n",
                                        blackjack.getHandTotal("player"));
                                turn = "dealer";
                            }
                        }
                    } else {
                        System.out.println("You busted! Game over!");
                        System.exit(0);
                    }
                    break;
                case "dealer":
                    if (blackjack.getHandTotal("dealer") == 21) {
                        System.out.println("Dealer has 21 and is staying");
                        turn = "exit";
                    } else if (blackjack.getHandTotal("dealer") <= 15) {
                        System.out.print("Dealer hitting!");
                        blackjack.drawCard("dealer");
                    } else if (blackjack.getHandTotal("dealer") > 21) {
                        System.out.println("Dealer busted! You win! Congrats");
                        System.exit(0);
                    } else {
                        System.out.print("Dealer staying!");
                        turn = "exit";
                    }
                    break;
            }

            if (turn.equals("exit")) {
                break;
            } else if (turn.equals("player")) {

                System.out.print("Do you want to stop playing? (y/n) ");
                if (scanner.nextLine().toLowerCase().startsWith("y")) {
                    System.out.println("Okay, hope you had fun! Bye");
                    break;
                }
            }
        }

        if (blackjack.getHandTotal("dealer") < blackjack.getHandTotal("player")) {
            System.out.println("\n\n\t\tYOU WIN!!!!\n\t\tCONGRATS!!");
        } else if (blackjack.getHandTotal("dealer") == blackjack.getHandTotal("player")) {
            System.out.println("\n\n\t\tNot bad a draw.\n\t\tCongrats, I guess.");
        } else {
            System.out.println("\n\n\t\tGame Over.\n\t\tYou lose!");
        }
    }

    /** to be built */
    private static void playUNO() {
        System.out.println("Still to be built - try again later");
        System.exit(0);
    }
}