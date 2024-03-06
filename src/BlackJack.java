import java.util.*;

public class BlackJack extends ClassicPlayingCards {
    public BlackJack() {
        // build the deck
        setupDeck();

        // call draw card to return a new Card to add to Dealer's hand
        // Then repeat with player so everyone has 2 starting cards
        drawCard("dealer");
        drawCard("dealer");

        drawCard("player");
        drawCard("player");
    }

    protected void drawCard(String who) {
        /*
          Wrapper function - it calls the drawcard and then adds that to the
          person passed (dealer or player's) deck.

          @param String who is drawing card (player or dealer)
         */

        switch (who.toLowerCase()) {
            case "player":
                playerHand.add(drawCard());
                break;
            case "dealer":
                dealerHand.add(drawCard());
                break;
        }
    }
    protected String getHand(String who) {
        // Build the hand using method chaining of appends & a join of values
        StringBuilder hand = new StringBuilder();

        if (who.equalsIgnoreCase("player")) {
            for (var card : playerHand) {
                hand.append("Card is: ").append(
                        String.join(" ", card.face(), card.suit())
                ).append("\n");
            }
        } else if (who.equalsIgnoreCase("dealer")) {
            for (var card : dealerHand) {
                hand.append("Card is: ").append(
                        String.join(" ", card.face(), card.suit())
                ).append("\n");
            }
        }

        return hand.toString();
    }

    protected int getHandTotal(String who) {
        // very simply - just for loop over hand and total the values
        int total = 0;

        if (who.equalsIgnoreCase("player")) {
            for (var card : playerHand) {
                // I can do this with Stream in 1 line no for but:
                total += card.value();
            }
        } else if (who.equalsIgnoreCase("dealer")) {
            for (var card : dealerHand) {
                // I can do this with Stream in 1 line no for but:
                total += card.value();
            }
        }

        return total;
    }
}
