package org.zerock.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.ReplyDTO;
import org.zerock.board.dto.ReplyPageDTO;
import org.zerock.board.service.ReplyService;

import java.util.List;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReplyPageDTO> getListByBoard(@PathVariable("bno") Long bno,
                                                       @RequestParam(defaultValue = "1") int page) {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(page).size(10).build();
        ReplyPageDTO replyPageDTO = replyService.getListOfBoard(bno, pageRequestDTO);
        return new ResponseEntity<>(replyPageDTO, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO){
        Long rno = replyService.register(replyDTO);
        return new ResponseEntity<>(rno, HttpStatus.OK);
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
        replyService.remove(rno);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO) {
        replyService.modify(replyDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
