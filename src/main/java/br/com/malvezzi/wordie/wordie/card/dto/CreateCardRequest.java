package br.com.malvezzi.wordie.wordie.card.dto;

import java.util.UUID;

public record CreateCardRequest(
  String front,
  String back,
  UUID deckId
) {}
