package com.uzhnu.epam.course.week3;

import java.util.Collections;
import java.util.List;

public class Deck {
    private final java.util.List<Card> orderedCards;
    private final java.util.List<Card> shuffledCards;

    private java.util.List<Card> deck;
    private java.util.Iterator<Card> iterator;

    public Deck() {
        this.orderedCards = create();
        java.util.List<Card> cards = create();
        java.util.Collections.shuffle(cards);
        this.shuffledCards = cards;
        this.iterator = orderedCards.iterator();

        this.deck = orderedCards;
        this.iterator = deck.iterator();
    }

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        this.deck = shuffledCards;
        this.iterator = deck.iterator();
    }

    /* * Впорядкування колоди за мастями та значеннями
     * Порядок сотрування:
     * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
     * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
     * Наприклад
     * HEARTS Ace
     * HEARTS King
     * HEARTS Queen
     * HEARTS Jack
     * HEARTS 10
     * HEARTS 9
     * HEARTS 8
     * HEARTS 7
     * HEARTS 6
     * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {
        this.deck = orderedCards;
        this.iterator = deck.iterator();
    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        return iterator.hasNext();
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ...,  CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        if (hasNext()) {
            return iterator.next();
        } else {
            return null;
        }
    }

    static java.util.List<Card> create() {
        final java.util.List<Card> cards = new java.util.LinkedList<>();

        Suit[] suits = Suit.values;
        int suitSize = suits.length;
        Rank[] ranks = Rank.values;
        int rankSize = ranks.length;

        for (int i = suitSize - 1; i >= 0; i--) {
            Suit suit = suits[i];
            for (int j = rankSize - 1; j >= 0; j--) {
                Rank rank = ranks[j];
                cards.add(new Card(rank, suit));
            }
        }

        return cards;
    }
}
