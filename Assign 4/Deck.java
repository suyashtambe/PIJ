import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();

        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                this.cards.add(new Card(j + 1, suits[i]));
            }
        }
        Collections.shuffle(this.cards);
    }

    public ArrayList<Card> getDeck() {
        return cards;
    }

    public Card getCard() {
        return cards.get(0);
    }
}
