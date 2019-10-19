package com.uzhnu.epam.course.week3;

import java.util.Objects;

public class Rank {
    public static final Rank ACE = new Rank("Ace");
    public static final Rank KING = new Rank("King");
    public static final Rank QUEEN = new Rank("Queen");
    public static final Rank JACK = new Rank("Jack");
    public static final Rank TEN = new Rank("10");
    public static final Rank NINE = new Rank("9");
    public static final Rank EIGHT = new Rank("8");
    public static final Rank SEVEN = new Rank("7");
    public static final Rank SIX = new Rank("6");

    public static Rank[] values = { ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX };

    private String name;

    Rank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return Objects.equals(name, rank.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
