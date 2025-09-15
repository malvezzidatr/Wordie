package br.com.malvezzi.wordie.wordie.decks.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.malvezzi.wordie.wordie.decks.dto.DeckResponse;
import br.com.malvezzi.wordie.wordie.decks.service.DeckService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeckController {

  private final DeckService deckService;

  @GetMapping("/v1/deck/{userId}")
  public List<DeckResponse> getUserDecks(@PathVariable UUID userId) {
      return deckService.getDecksByUserId(userId);
  }
  
}
