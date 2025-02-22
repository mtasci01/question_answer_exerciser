package com.mt.question_answer_exerciser.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QAPairRepository extends JpaRepository<QAPair, UUID> {
    long deleteByGameId(UUID gameId);

    @Query(value  = "SELECT * FROM QAPair WHERE game_Id = 'c8a371a9-9362-487b-8764-b2657dc8b2c4' AND (guessed = FALSE OR guessed IS NULL) ORDER BY RANDOM() LIMIT 1;"
            , nativeQuery = true)
    QAPair pickUnansweredQuestion(UUID gameId);

    @Modifying
    @Query("update QAPair q set q.guessed = null, q.updateTimestamp = ?2 where q.gameId = ?1")
    int resetQAGuessed(UUID gameId, long updateTimestamp);
}
