package my.test.Task.Management.System.CommentManagement;

import jakarta.persistence.*;
import lombok.*;
import my.test.Task.Management.System.TaskManagement.Task;
import my.test.Task.Management.System.Usr.User;

import java.time.LocalDateTime;

@Entity
//@Data
//@AllArgsConstructor
//@Getter
//@Setter
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Comment setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}