package cs.borrowdonga.dto.post;

import cs.borrowdonga.domain.post.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostUpdateRequestDto {

    private String content;
    private String imageUrl;

    @Builder
    public PostUpdateRequestDto(String content, String imageUrl) {
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
