package br.com.malvezzi.wordie.wordie.decks.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.malvezzi.wordie.wordie.decks.dto.DeckRequest;
import br.com.malvezzi.wordie.wordie.decks.dto.DeckResponse;
import br.com.malvezzi.wordie.wordie.decks.service.DeckService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/deck")
public class DeckController {

  private final DeckService deckService;

  @GetMapping("/{userId}")
  public List<DeckResponse> getUserDecks(@PathVariable UUID userId) {
      return deckService.getDecksByUserId(userId);
  }
  
  @PostMapping("/{userId}")
  public void createNewDeck(
    @PathVariable UUID userId,
    @RequestBody DeckRequest deckRequest
  ) {
    deckService.createNewDeck(userId, deckRequest);
  }
}
