package com.mt.question_answer_exerciser;

import com.mt.question_answer_exerciser.dto.GameDTO;
import com.mt.question_answer_exerciser.dto.QAPairDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class QAController {

    private final QAService qaService;

    @PostMapping("/create_game")
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO dto) {
        return ResponseEntity.ok(qaService.createGame(dto));
    }

    @PostMapping(value = "/upload_qas")
    public ResponseEntity<String> uploadQAs(@RequestBody List<QAPairDTO> dtoL, @RequestParam String gameId,
                                            @RequestParam(required = false) boolean override) {
        long saved = qaService.uploadQAs(dtoL,gameId,override);
        return new ResponseEntity<>("Num Saved: " + saved, HttpStatus.OK);
    }

    @PutMapping(value = "/update_qapair_guessed")
    public ResponseEntity<String> updateQAPairGuessed(@RequestParam String id, @RequestParam boolean guessed) {
        qaService.updateQAPairGuessed(id, guessed);
        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete_game")
    public ResponseEntity<String> uploadQAs(@RequestParam String gameId) {
        long deleted = qaService.deleteGame(gameId);
        return new ResponseEntity<>("Num deleted: " + deleted, HttpStatus.OK);
    }

    @GetMapping(value = "/delete_game")
    public ResponseEntity<String> getGame(@RequestParam String gameId) {
        long deleted = qaService.deleteGame(gameId);
        return new ResponseEntity<>("Num deleted: " + deleted, HttpStatus.OK);
    }

    @GetMapping(value = "/get_rand_unans_qa")
    public ResponseEntity<QAPairDTO> getRandUnansQA(@RequestParam String gameId) {
        QAPairDTO dto = qaService.getRandUnansQA(gameId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }



}
