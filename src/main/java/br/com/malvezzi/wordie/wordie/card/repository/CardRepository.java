package br.com.malvezzi.wordie.wordie.card.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.malvezzi.wordie.wordie.card.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
  List<Card> findByDeckId(UUID deckId);
}
