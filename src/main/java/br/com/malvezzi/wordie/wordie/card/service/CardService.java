package br.com.malvezzi.wordie.wordie.card.service;

import java.util.List;
import java.util.UUID;

import br.com.malvezzi.wordie.wordie.card.dto.CardResponse;
import br.com.malvezzi.wordie.wordie.card.dto.CreateCardRequest;

public interface CardService {

  void createNewCard(UUID deckId, List<CreateCardRequest> createCardRequest);
  List<CardResponse> getDeckCards(UUID deckId);

}
