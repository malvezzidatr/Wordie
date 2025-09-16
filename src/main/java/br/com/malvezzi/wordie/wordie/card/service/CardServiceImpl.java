package br.com.malvezzi.wordie.wordie.card.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.malvezzi.wordie.wordie.card.dto.CardResponse;
import br.com.malvezzi.wordie.wordie.card.dto.CreateCardRequest;
import br.com.malvezzi.wordie.wordie.card.model.Card;
import br.com.malvezzi.wordie.wordie.card.repository.CardRepository;
import br.com.malvezzi.wordie.wordie.decks.model.Deck;
import br.com.malvezzi.wordie.wordie.decks.repository.DeckRepository;
import br.com.malvezzi.wordie.wordie.user.model.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
  
  private final CardRepository cardRepository;
  private final DeckRepository deckRepository;

  @Override
  public void createNewCard(UUID deckId, CreateCardRequest createCardRequest) {
    Deck deck = deckRepository.findById(deckId)
        .orElseThrow(() -> new RuntimeException("Deck não encontrado: " + deckId));

    Card card = Card.builder()
            .front(createCardRequest.front())
            .back(createCardRequest.back())
            .deck(deck)
            .build();
    
    cardRepository.save(card);
  }

  @Override
  public List<CardResponse> getDeckCards(UUID deckId) {
    List<CardResponse> cards = cardRepository
            .findByDeckId(deckId)
            .stream()
            .map(card ->
              new CardResponse(
                card.getFront(),
                card.getBack()))
            .toList();
    return cards;
  }

}
