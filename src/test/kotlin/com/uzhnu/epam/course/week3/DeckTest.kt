package com.uzhnu.epam.course.week3

import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object DeckTest : Spek({
    describe("order") {
        it("should order cards in reverse") {
            val deck = Deck().apply { order() }

            listOf(Suit.SPADES, Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS).forEach { suit ->
                assertEquals(deck.drawOne(), Card(Rank.SIX, suit))
                assertEquals(deck.drawOne(), Card(Rank.SEVEN, suit))
                assertEquals(deck.drawOne(), Card(Rank.EIGHT, suit))
                assertEquals(deck.drawOne(), Card(Rank.NINE, suit))
                assertEquals(deck.drawOne(), Card(Rank.TEN, suit))
                assertEquals(deck.drawOne(), Card(Rank.JACK, suit))
                assertEquals(deck.drawOne(), Card(Rank.QUEEN, suit))
                assertEquals(deck.drawOne(), Card(Rank.KING, suit))
                assertEquals(deck.drawOne(), Card(Rank.ACE, suit))
            }
        }
    }
    describe("shuffle") {
        it("should make cards in random order") {
            val deck = Deck().apply {
                order()
                shuffle()
            }
            assertNotEquals(deck.drawOne(), Card(Rank("6"), Suit("SPADES")))
        }
    }
})
