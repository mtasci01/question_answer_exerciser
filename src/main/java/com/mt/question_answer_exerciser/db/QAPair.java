package com.mt.question_answer_exerciser.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "QAPair")
public class QAPair {
    @Id
    private UUID id;
    private UUID gameId;
    private String question;
    private String answer;
    private Long createTimestamp;
    private Long updateTimestamp;
    private Boolean guessed;
}