package ch.gibb.indexcards;

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

    public Card(Integer id, String definition, String term) {
        this.id = id;
        this.definition = definition;
        this.term = term;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(definition, card.definition) && Objects.equals(term, card.term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, definition, term);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", definition='" + definition + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
