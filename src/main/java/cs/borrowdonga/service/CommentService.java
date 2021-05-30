package cs.borrowdonga.service;

import cs.borrowdonga.domain.comment.Comment;
import cs.borrowdonga.domain.comment.CommentRepository;
import cs.borrowdonga.domain.member.Member;
import cs.borrowdonga.domain.member.MemberRepository;
import cs.borrowdonga.domain.post.Post;
import cs.borrowdonga.domain.post.PostRepository;
import cs.borrowdonga.dto.comment.CommentCreateRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public void create(CommentCreateRequestDto requestDto) {
        Post post = postRepository
            .findById(requestDto.getPostId())
            .orElseThrow(IllegalArgumentException::new);
        Member member = memberRepository
            .findMemberByStudentNumber(requestDto.getStudentNumber());

        Comment comment = requestDto.toEntity(post, member);

        commentRepository.save(comment);
    }

    protected List<Comment> readAll(Long postId) {
        return commentRepository.findCommentsByPostId(postId);
    }
}
