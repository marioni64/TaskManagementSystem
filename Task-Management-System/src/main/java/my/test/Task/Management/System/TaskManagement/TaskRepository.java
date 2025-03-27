package my.test.Task.Management.System.TaskManagement;

import my.test.Task.Management.System.Enum.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE " +
            "(:authorId IS NULL OR t.author.id = :authorId) AND " +
            "(:assigneeId IS NULL OR t.assignee.id = :assigneeId) AND " +
            "(:status IS NULL OR t.status = :status)")
    Page<Task> findFilteredTasks(
            @Param("authorId") Long authorId,
            @Param("assigneeId") Long assigneeId,
            @Param("status") TaskStatus status,
            Pageable pageable
    );
}