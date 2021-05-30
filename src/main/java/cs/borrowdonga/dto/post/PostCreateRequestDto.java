package cs.borrowdonga.dto.post;

import cs.borrowdonga.domain.member.Member;
import cs.borrowdonga.domain.post.Post;
import java.util.Collections;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class PostCreateRequestDto {

    private String content;
    private String imageUrl;
    private String studentNumber;

    @Builder
    public PostCreateRequestDto(String content, String imageUrl, String studentNumber) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.studentNumber = studentNumber;
    }

    public Post toEntity(Member member) {
        return Post.builder()
            .content(content)
            .imageUrl(imageUrl)
            .hits(0L)
            .likes(0L)
            .member(member)
            .comments(Collections.emptyList())
            .build();
    }
}
