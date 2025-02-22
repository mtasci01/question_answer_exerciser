package com.mt.question_answer_exerciser.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QAPairRepository extends JpaRepository<QAPair, UUID> {
    long deleteByGameId(UUID gameId);

    @Query(value  = "select * from QAPair WHERE game_Id = 'c8a371a9-9362-487b-8764-b2657dc8b2c4' AND (guessed = false OR guessed IS NULL) order by random() limit 1;"
            , nativeQuery = true)
    QAPair pickUnansweredQuestion(UUID gameId);
}
