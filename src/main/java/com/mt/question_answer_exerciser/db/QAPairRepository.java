package com.mt.question_answer_exerciser.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QAPairRepository extends JpaRepository<QAPair, UUID> {
    long deleteByGameId(UUID gameId);
}
