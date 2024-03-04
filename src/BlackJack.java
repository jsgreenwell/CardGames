import java.util.*;

public class BlackJack {
    // default values to use then remove (cause only on per deck)
    // using Card record to hold a suit, face, value so
    // Ace of Spades would be Suit "Spades", Face "Ace", value 1...or 11?
    protected record Card(String suit, String face, int value){}
    private List<Card> deck = new ArrayList<>();

    // Here the user's hand and the dealers (a list of card objects)
    private List<Card> dealerHand = new ArrayList<>();
    private List<Card> playerHand = new ArrayList<>();

    public BlackJack() {
        // build the deck
        for (String suit : new String[] { "Spade", "Heart", "Diamond", "Club"}) {
            for (int i=1; i<=10; i++) {
                switch (i) {
                    case 1:
                        deck.add(new Card(suit, "Ace", 1));
                        deck.add(new Card(suit, "1", 1));
                        break;
                    case 10:
                        deck.add(new Card(suit, "King", 10));
                        deck.add(new Card(suit, "Queen", 10));
                        deck.add(new Card(suit, "Jack", 10));
                        deck.add(new Card(suit, "10", 10));
                        break;
                    default:
                        deck.add(new Card(suit, String.valueOf(i), i));
                }
            }
        }
        // Randomize order of deck - they even call it shuffle
        Collections.shuffle(deck);

        // call draw card to return a new Card to add to Dealer's hand
        // Then repeat with player so everyone has 2 starting cards
        drawCard("dealer");
        drawCard("dealer");

        drawCard("player");
        drawCard("player");
    }

    protected Card drawCard() {
        /*
          Return a random card from deck & remove it from play (deck)
          @return random card
         */
        int idx = new Random().nextInt(deck.size());
        Card temp = deck.get(idx);
        deck.remove(idx);
        return temp;
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
