package ch.gibb.indexcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private DeckRepository deckRepository;

    @GetMapping
    public List<Deck> getDecks(){
        return deckRepository.findAll();
    }

    record NewDeckRequest(
            String name
    ){

    }

    @PostMapping
    public void addDeck(@RequestBody NewDeckRequest request){
        Deck deck = new Deck();
        deck.setName(request.name);
        deckRepository.save(deck);
    }

    @PutMapping
    public void updateDeck(@RequestBody Deck deck){
        deckRepository.save(deck);
    }

    @DeleteMapping("{deckId}")
    public void deleteDeck(@PathVariable("deckId") Integer id){
        deckRepository.deleteById(id);
    }

}
