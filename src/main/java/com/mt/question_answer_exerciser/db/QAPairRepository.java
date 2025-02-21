package com.mt.question_answer_exerciser.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QAPairRepository extends JpaRepository<QAPair, UUID> {
    long deleteByGameId(UUID gameId);

    //@Query("select q from QAPair q WHERE q.gameId = ?1 AND q.order by RAND()")
    //public QAPair findRandomQuestion(UUID gameId, );
}
