package br.com.malvezzi.wordie.wordie.decks.service;

import java.util.List;
import java.util.UUID;

import br.com.malvezzi.wordie.wordie.decks.dto.DeckRequest;
import br.com.malvezzi.wordie.wordie.decks.dto.DeckResponse;

public interface DeckService {

    List<DeckResponse> getDecksByUserId(UUID userId);
    void createNewDeck(UUID userId, DeckRequest deckRequest);

}
