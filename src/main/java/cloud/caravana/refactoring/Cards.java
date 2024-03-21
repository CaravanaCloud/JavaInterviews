package cloud.caravana.refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cards {
    private List<Card> cards;

    public Cards() {
        cards = new ArrayList<>();
        initializeCards();
    }

    private void initializeCards() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card pickFirstCard() {
        return cards.get(0);
    }



    private class Card {
        private String rank;
        private String suit;

        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return rank.equals(card.rank) && suit.equals(card.suit);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rank, suit);
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

    public static void main(String[] args) {
        Cards cards = new Cards();
        cards.shuffle();
        Card firstCard = cards.pickFirstCard();
        System.out.println("First card: " + firstCard);
    }
}
