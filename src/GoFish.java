/**
 * Rules of Go Fish (2-player)
 *   1. Start with Deal of 7 to each player
 *   2. Player asks Dealer for card
 *       - Player must have at least 1 of that card in their hand
 *       - Only have to ask for face (1, 2, Kings, Aces, etc.) not suit
 *   3. Dealer checks for a card of that face in hand
 *       - If card found, they must give one to player
 *       - Else Player must gofish
 *   4. Player adds card to hand from Fish (draws card from deck) or dealer
 *   5. Player checks if they have all 4 cards in a set and makes a book if so
 *       - Books are safe and count for 1 point
 *   6. Repeat 2-5 (alternating players) until set number of books gotten (or all)
 *   7. Add up totals (1pt each book) and highest total wins
 *
 */
public class GoFish extends ClassicPlayingCards {
    /**
     * Basic Constructor - sets up deck and hands
      */
    public GoFish() {
         // build the deck
         setupDeck();

         // Deal out 7 random cards to dealer and player
        for (int i=0; i<7; i++) {
            playerHand.add(drawCard());
            dealerHand.add(drawCard());
        }
    }

    public String showPlayersHand() {
        // Build the hand using method chaining of appends & a join of values
        StringBuilder hand = new StringBuilder();

        hand.append("Player's Hand is: \n");
        for (var card : playerHand) {
            hand.append("\tCard is: ").append(
                    String.join(" of ", card.face(), card.suit())
            ).append("\n");
        }

        return hand.toString();
    }

    protected String fishing(String person) {
        // just add the next item in Deck and then remove from deck
        // its already random
        Card tempcard = deck.get(0);
        deck.remove(0);

        if (person.equals("player")) {
            playerHand.add(tempcard);
        } else {
            dealerHand.add(tempcard);
        }
        return String.format("Added %s of %s",
                tempcard.face(), tempcard.suit());
    }

    protected boolean checkHand(String person, String cardFace) {
        // If it's the dealer -> we check the player's hand
        // Dealer is easier because we only need to check the player's hand
        // The Choice of the dealer is made from there hand
        if (person.equals("dealer")) {
            for (var card : playerHand) {
                if (card.face().toLowerCase().startsWith(cardFace)) {
                    dealerHand.add(card);
                    playerHand.remove(card);
                    return true;
                }
            }
        } else {
            // For player, we have to check both their own hand and player's hand
            for (var card : playerHand) {
                if (card.face().toLowerCase().startsWith(cardFace)) {
                    for (var dcard : dealerHand) {
                        if (dcard.face().toLowerCase().startsWith(cardFace)) {
                            playerHand.add(dcard);
                            dealerHand.remove(dcard);
                            return true;
                        }
                        // extra return false because we only need to check once
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
