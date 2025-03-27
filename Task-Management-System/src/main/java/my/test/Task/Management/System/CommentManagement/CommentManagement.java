package my.test.Task.Management.System.CommentManagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentManagement extends JpaRepository<Comment, Long> {
}
