package com.mt.question_answer_exerciser.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
@Table(name = "Game")
public class Game {
        @Id
        private UUID id;
        private String description;
        private Long creationTimestamp;
}
