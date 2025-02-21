package com.mt.question_answer_exerciser.dto;

import lombok.Data;

@Data
public class QAPairDTO {
    private String id;
    private String gameId;
    private String question;
    private String answer;
    private Long createTimestamp;
    private Long updateTimestamp;
    private Boolean guessed;
}