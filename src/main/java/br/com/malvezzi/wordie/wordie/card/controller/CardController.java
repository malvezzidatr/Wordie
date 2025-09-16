package br.com.malvezzi.wordie.wordie.card.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.malvezzi.wordie.wordie.card.dto.CardResponse;
import br.com.malvezzi.wordie.wordie.card.dto.CreateCardRequest;
import br.com.malvezzi.wordie.wordie.card.service.CardService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class CardController {

  private final CardService cardService;

  @PostMapping("/v1/card/new/{deckId}")
  public void createNewCard(
    @PathVariable UUID deckId,
    @RequestBody CreateCardRequest createCardRequest
  ) {
    cardService.createNewCard(deckId, createCardRequest);
  }

  @GetMapping("/v1/card/{deckId}")
  public List<CardResponse> getDeckCards(@PathVariable UUID deckId) {
    return cardService.getDeckCards(deckId);
  }
  
}
