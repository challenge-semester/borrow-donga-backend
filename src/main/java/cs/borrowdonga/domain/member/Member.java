package cs.borrowdonga.domain.member;

import cs.borrowdonga.domain.BaseTimeEntity;
import cs.borrowdonga.domain.comment.Comment;
import cs.borrowdonga.domain.favorite.Favorite;
import cs.borrowdonga.domain.post.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String password;

    private String username;

    private String email;

    private String phoneNumber;

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

    @Builder
    public Member(String password, String username, String email, String phoneNumber, String department, String studentNumber, MemberRole role) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.studentNumber = studentNumber;
        this.role = role;
    }
}
