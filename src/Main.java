import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* BlackJack code answers
        BlackJack blackjack = new BlackJack();
        Scanner scan = new Scanner(System.in);

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
                        if (scan.nextLine().toLowerCase().startsWith("yes")) {
                            blackjack.drawCard("player");
                        } else {
                            System.out.print("Do you want to stay? (yes/no)");
                            if (scan.nextLine().toLowerCase().startsWith("yes")) {
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
                if (scan.nextLine().toLowerCase().startsWith("y")) {
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

         */
        // Now for the go fish - maybe it will be simpler
        // Added player logic - will add dealer (AI) logic later

        Scanner scan = new Scanner(System.in);
        GoFish fish = new GoFish();
        System.out.println(fish.dealerHand.toString());

        System.out.println(fish.showPlayersHand());
        System.out.print("""

                \t\ttRemember you must search for a face in hand
                \t\tOur else you'll have to 'Go Fish'
                What card do you want to search for? (face)""");
        if (fish.checkHand("player", scan.nextLine())) {
            System.out.println("Other player has a match! Your hand is now: ");
            System.out.println(fish.showPlayersHand());
        } else {
            System.out.printf("No match - you go fish and get a %s ",
                    fish.fishing("player"));
        }
    }
}