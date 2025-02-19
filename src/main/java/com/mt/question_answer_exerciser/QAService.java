package com.mt.question_answer_exerciser;

import com.mt.question_answer_exerciser.db.QAPair;
import com.mt.question_answer_exerciser.db.QAPairRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class QAService {

    private final QAPairRepository qaPairRepository;

    @PostConstruct
    public void testT(){
        QAPair qaPair = new QAPair();
        qaPair.setId(UUID.randomUUID());
        qaPair.setAnswer(UUID.randomUUID().toString());
        qaPair.setQuestion(UUID.randomUUID().toString());
        qaPair.setTimestamp(Instant.now().toEpochMilli());
        qaPairRepository.save(qaPair);
        log.info("CREated test db object");

    }
}
