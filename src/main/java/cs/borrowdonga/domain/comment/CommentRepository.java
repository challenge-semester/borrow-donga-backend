package cs.borrowdonga.domain.comment;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findCommentsByPostId(Long postId);
}
