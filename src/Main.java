public class Main {
    public static void main(String[] args) {
        // Finish this up over weekend
        BlackJack blackjack = new BlackJack();

        for (var c : blackjack.deck) {
            System.out.println(c.face());
            System.out.println(c.value());
            System.out.println(c.suit());
            System.out.println(c.toString());
        }
    }
}