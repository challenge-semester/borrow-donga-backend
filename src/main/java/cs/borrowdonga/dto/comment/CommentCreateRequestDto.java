package cs.borrowdonga.dto.comment;

import cs.borrowdonga.domain.comment.Comment;
import cs.borrowdonga.domain.member.Member;
import cs.borrowdonga.domain.post.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentCreateRequestDto {

    private String studentNumber;
    private Long postId;
    private String content;

    public Comment toEntity(Post post, Member member) {
        return Comment.builder()
            .content(content)
            .likes(0L)
            .member(member)
            .post(post)
            .build();
    }
}
