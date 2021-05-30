package cs.borrowdonga.domain.post;

import cs.borrowdonga.domain.BaseTimeEntity;
import cs.borrowdonga.domain.comment.Comment;
import cs.borrowdonga.domain.member.Member;
import cs.borrowdonga.dto.post.PostUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

//    @Lob
    private String content;

    private String imageUrl;

    private Long hits;

    private Long likes;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(Long id, String content, String imageUrl, Long hits, Long likes, Member member, List<Comment> comments) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.hits = hits;
        this.likes = likes;
        this.member = member;
        this.comments = comments;
    }

    public Long update(PostUpdateRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.imageUrl = requestDto.getImageUrl();
        return this.id;
    }

    public void increaseHits() {
        this.hits++;
    }
}
