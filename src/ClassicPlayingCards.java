import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class ClassicPlayingCards {
    // default values to use then remove (cause only on per deck)
    // using Card record to hold a suit, face, value so
    // Ace of Spades would be Suit "Spades", Face "Ace", value 1...or 11?
    protected record Card(String suit, String face, int value){}
    protected List<Card> deck = new ArrayList<>();

    // Here the user's hand and the dealers (a list of card objects)
    protected List<Card> dealerHand = new ArrayList<>();
    protected List<Card> playerHand = new ArrayList<>();

    protected void setupDeck() {
        for (String suit : new String[] { "Spades", "Hearts", "Diamonds", "Clubs"}) {
            for (int i = 1; i <= 10; i++) {
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
}
