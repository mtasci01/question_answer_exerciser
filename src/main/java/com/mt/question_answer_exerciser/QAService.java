package com.mt.question_answer_exerciser;

import com.mt.question_answer_exerciser.db.Game;
import com.mt.question_answer_exerciser.db.GameRepository;
import com.mt.question_answer_exerciser.db.QAPair;
import com.mt.question_answer_exerciser.db.QAPairRepository;
import com.mt.question_answer_exerciser.dto.GameDTO;
import com.mt.question_answer_exerciser.dto.QAPairDTO;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        log.info("Created game with id " + gameDB.getId());
        return modelMapper.map(gameDB, GameDTO.class);
    }

    @Transactional
    public int uploadQAs(List<QAPairDTO> dtoL, String gameId, boolean override){

        Game game = gameRepository.findById(UUID.fromString(gameId)).orElse(null);
        if (game == null)
            throw new IllegalArgumentException("Invalid gameid: " + gameId);

        if (override) {
            long deleted = qaPairRepository.deleteByGameId(UUID.fromString(gameId));
            log.info("deleted num qaPairs: " + deleted);
        }

        List<QAPair> dbL = dtoL.stream().map(dto -> {
            QAPair qaPair = new QAPair();
            qaPair.setAnswer(dto.getAnswer());
            qaPair.setQuestion(dto.getQuestion());
            qaPair.setTimestamp(Instant.now().toEpochMilli());
            qaPair.setId(UUID.randomUUID());
            qaPair.setGameId(UUID.fromString(gameId));
            return qaPair;
        }).collect(Collectors.toList());

        qaPairRepository.saveAll(dbL);
        log.info("Created num qaPairs: " + dbL.size());
        return dbL.size();
    }
}
