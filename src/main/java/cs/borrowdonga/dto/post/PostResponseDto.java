package cs.borrowdonga.dto.post;

import cs.borrowdonga.domain.comment.Comment;
import cs.borrowdonga.domain.member.Member;
import cs.borrowdonga.domain.post.Post;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {

    private Long id;
    private String content;
    private String imageUrl;
    private Long hits;
    private Long likes;
    private String studentNumber;
    private String username;
    private List<Comment> comments = new ArrayList<>();

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.content = post.getContent();
        this.imageUrl = post.getImageUrl();
        this.hits = post.getHits();
        this.likes = post.getLikes();
        this.studentNumber = post.getMember().getStudentNumber();
        this.username = post.getMember().getUsername();
        this.comments = post.getComments();
    }
}
