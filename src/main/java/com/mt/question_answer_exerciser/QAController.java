package com.mt.question_answer_exerciser;

import com.mt.question_answer_exerciser.dto.GameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QAController {

    private final QAService qaService;

    @PostMapping("/create_game")
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO dto) {

        return ResponseEntity.ok(qaService.createGame(dto));

    }

    /*@GetMapping("/get_all_reports")
    public ResponseEntity<List<ReportDTO>> getReports() {

        return ResponseEntity.ok(qaService.getReports());

    }*/


}
