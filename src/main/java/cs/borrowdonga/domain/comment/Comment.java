package cs.borrowdonga.domain.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cs.borrowdonga.domain.BaseTimeEntity;
import cs.borrowdonga.domain.member.Member;
import cs.borrowdonga.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    //    @Lob
    private String content;

    private Long likes;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment(Long id, String content, Long likes, Member member, Post post) {
        this.id = id;
        this.content = content;
        this.likes = likes;
        this.member = member;
        this.post = post;
    }
}
