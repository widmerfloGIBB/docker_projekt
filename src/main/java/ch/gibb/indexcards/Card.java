package ch.gibb.indexcards;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Card {

    @Id
    @SequenceGenerator(
            name = "card_id_sequence",
            sequenceName = "card_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "card_id_sequence"
    )
    private Integer id;
    private String definition;
    private String term;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="deck_id")
    private Deck deck;

    public Card(Integer id, String definition, String term, Deck deck) {
        this.id = id;
        this.definition = definition;
        this.term = term;
        this.deck = deck;
    }

    public Card(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(definition, card.definition) && Objects.equals(term, card.term) && Objects.equals(deck, card.deck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, definition, term, deck);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", definition='" + definition + '\'' +
                ", term='" + term + '\'' +
                ", deck=" + deck +
                '}';
    }
}
