package com.mt.question_answer_exerciser.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QAPairRepository extends JpaRepository<QAPair, UUID> {
    long deleteByGameId(UUID gameId);

    @Query(value  = "SELECT * FROM QAPair WHERE game_Id = ?1 AND (guessed = FALSE OR guessed IS NULL) ORDER BY RANDOM() LIMIT 1;"
            , nativeQuery = true)
    QAPair pickUnansweredQuestion(UUID gameId);

    @Modifying
    @Query("update QAPair q set q.guessed = null, q.updateTimestamp = ?2 where q.gameId = ?1")
    int resetQAGuessed(UUID gameId, long updateTimestamp);

    @Query("select count(q) from QAPair q where (q.guessed = false or q.guessed is null)  and q.gameId = ?1")
    int getNumLeft(UUID gameId);
}
