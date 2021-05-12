package cs.borrowdonga.domain.member;

import cs.borrowdonga.domain.BaseTimeEntity;
import cs.borrowdonga.domain.comment.Comment;
import cs.borrowdonga.domain.favorite.Favorite;
import cs.borrowdonga.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String department;

    private String studentNumber;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @OneToMany(mappedBy = "member")
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();
}
