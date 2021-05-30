package cs.borrowdonga.controller;

import cs.borrowdonga.dto.comment.CommentCreateRequestDto;
import cs.borrowdonga.service.CommentService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/new")
    public ResponseEntity<Void> create(@Valid @RequestBody CommentCreateRequestDto requestDto) {
        commentService.create(requestDto);
        return ResponseEntity.ok().build();
    }
}
