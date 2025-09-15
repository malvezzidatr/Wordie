package br.com.malvezzi.wordie.wordie.decks.service;

import java.util.List;
import java.util.UUID;

import br.com.malvezzi.wordie.wordie.decks.dto.DeckResponse;

public interface DeckService {

    List<DeckResponse> getDecksByUserId(UUID userId);
  
}
