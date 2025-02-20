package com.mt.question_answer_exerciser;

import com.mt.question_answer_exerciser.db.Game;
import com.mt.question_answer_exerciser.db.GameRepository;
import com.mt.question_answer_exerciser.db.QAPairRepository;
import com.mt.question_answer_exerciser.dto.GameDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class QAService {

    private final QAPairRepository qaPairRepository;
    private final GameRepository gameRepository;

    ModelMapper modelMapper;
    @PostConstruct
    private void setUp(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public GameDTO createGame(GameDTO dto){
        Game gameDB = new Game();
        gameDB.setCreationTimestamp(Instant.now().toEpochMilli());
        gameDB.setId(UUID.randomUUID());
        gameDB.setDescription(dto.getDescription());
        gameRepository.save(gameDB);
        return modelMapper.map(gameDB, GameDTO.class);
    }
}
