package cs.borrowdonga.controller;

import cs.borrowdonga.dto.post.PostCreateRequestDto;
import cs.borrowdonga.dto.post.PostResponseDto;
import cs.borrowdonga.dto.post.PostUpdateRequestDto;
import cs.borrowdonga.service.PostService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class PostController {

    private final PostService postService;

    @PostMapping("/new")
    public ResponseEntity<Long> create(@Valid @RequestBody PostCreateRequestDto requestDto) {
        Long newPostId = postService.create(requestDto);
        return ResponseEntity.ok(newPostId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> read(@PathVariable(name = "postId") Long postId) {
        PostResponseDto responseDto = postService.read(postId);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Long> update(@PathVariable(name = "postId") Long postId,
        @Valid @RequestBody PostUpdateRequestDto requestDto) {
        Long updatedPostId = postService.update(postId, requestDto);
        return ResponseEntity.ok(updatedPostId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> delete(@PathVariable(name = "postId") Long postId) {
        postService.delete(postId);
        return ResponseEntity.ok().build();
    }
}
