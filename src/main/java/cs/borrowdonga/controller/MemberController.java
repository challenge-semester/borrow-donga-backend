package cs.borrowdonga.controller;

import cs.borrowdonga.domain.member.Member;
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
    public ResponseEntity<String> join(@Valid @RequestBody JoinRequestDto requestDto) {
        memberService.join(requestDto);
        return ResponseEntity.ok().build();
    }
}
