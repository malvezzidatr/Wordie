package br.com.malvezzi.wordie.wordie.decks.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.malvezzi.wordie.wordie.decks.dto.DeckRequest;
import br.com.malvezzi.wordie.wordie.decks.dto.DeckResponse;
import br.com.malvezzi.wordie.wordie.decks.model.Deck;
import br.com.malvezzi.wordie.wordie.decks.repository.DeckRepository;
import br.com.malvezzi.wordie.wordie.user.model.User;
import br.com.malvezzi.wordie.wordie.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeckServiceImpl implements DeckService {
  
  private final DeckRepository deckRepository;
  private final UserRepository userRepository;

  @Override
  public List<DeckResponse> getDecksByUserId(UUID userId) {
    List<DeckResponse> deckResponse = deckRepository.findDecksByUserId(userId)
        .stream()
        .map(deck -> new DeckResponse(
            deck.getId(),
            deck.getName(),
            deck.getDescription(),
            deck.getCreatedAt()
        ))
        .collect(Collectors.toList());;

    return deckResponse;
  }
  
  @Override
  public void createNewDeck(UUID userId, DeckRequest deckRequest) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + userId));

    Deck deck = Deck.builder()
          .name(deckRequest.name())
          .description(deckRequest.description())
          .user(user)
          .build();
    
    deckRepository.save(deck);
  }


}
