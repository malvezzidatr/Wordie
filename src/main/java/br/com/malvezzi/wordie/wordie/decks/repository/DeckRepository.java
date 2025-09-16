package br.com.malvezzi.wordie.wordie.decks.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.malvezzi.wordie.wordie.decks.model.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck, UUID> {
  List<Deck> findDecksByUserId(UUID userId);
}
