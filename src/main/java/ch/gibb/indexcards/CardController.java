package ch.gibb.indexcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public List<Card> getCards(){
        return cardRepository.findAll();
    }

    record NewCardRequest(
            String definition,
            String term){

    }

    @PostMapping
    public void addCard(@RequestBody NewCardRequest request){
        Card card = new Card();
        card.setDefinition(request.definition);
        card.setTerm(request.term);
        cardRepository.save(card);
    }

    @PutMapping
    public void updateCard(@RequestBody Card card){
        cardRepository.save(card);
    }

    @DeleteMapping("{cardId}")
    public void deleteCard(@PathVariable("cardId") Integer id){
        cardRepository.deleteById(id);
    }

}
