package cs.borrowdonga.controller;

import cs.borrowdonga.dto.member.DeleteRequestDto;
import cs.borrowdonga.dto.member.JoinRequestDto;
import cs.borrowdonga.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<Long> join(@Valid @RequestBody JoinRequestDto requestDto) {
        Long newMemberId = memberService.join(requestDto);
        return ResponseEntity.ok(newMemberId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@Valid @RequestBody DeleteRequestDto requestDto) {
        memberService.delete(requestDto);
        return ResponseEntity.ok().build();
    }
}
