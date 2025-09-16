package br.com.malvezzi.wordie.wordie.user.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.malvezzi.wordie.wordie.decks.model.Deck;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(name = "firebase_uid", nullable = false, unique = true)
  private String firebaseUid;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Deck> decks;

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
      this.createdAt = LocalDateTime.now();
  }

}
