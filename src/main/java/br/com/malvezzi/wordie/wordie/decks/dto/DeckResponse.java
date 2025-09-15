package br.com.malvezzi.wordie.wordie.decks.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeckResponse(
  UUID id,
  String name,
  String description,
  LocalDateTime createdAt
) {}
