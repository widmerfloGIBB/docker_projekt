package ch.gibb.indexcards;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;

import java.util.Objects;
import java.util.Set;

@Entity
public class Deck {

    @Id
    @SequenceGenerator(
            name = "deck_id_sequence",
            sequenceName = "deck_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "deck_id_sequence"
    )
    private Integer id;

    private String name;

    @OneToMany
    private Set<Card> cards = new HashSet<>();

    public Deck(){

    }

    public Deck(Integer id, String name, Set<Card> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(id, deck.id) && Objects.equals(name, deck.name) && Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cards);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
