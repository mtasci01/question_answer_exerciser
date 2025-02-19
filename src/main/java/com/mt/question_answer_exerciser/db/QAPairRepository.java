package com.mt.question_answer_exerciser.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QAPairRepository extends JpaRepository<QAPair, UUID> {
}
