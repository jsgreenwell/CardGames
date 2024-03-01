import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    // default values to use then remove (cause only on per deck)
    // using Card record to hold a suit, face, value so
    // Ace of Spades would be Suit "Spades", Face "Ace", value 1...or 11?
    public record Card(String suit, String face, int value){}
    protected List<Card> deck = new ArrayList<>();

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


    }
}
