package my.test.Task.Management.System.DTO;

import lombok.Getter;
import lombok.Setter;
import my.test.Task.Management.System.Enum.TaskStatus;
import my.test.Task.Management.System.Enum.Priority;

@Getter
@Setter
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private String authorName;
    private String assigneeName;
}