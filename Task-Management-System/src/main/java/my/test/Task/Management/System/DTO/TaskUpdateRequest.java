package my.test.Task.Management.System.DTO;

import lombok.Getter;
import lombok.Setter;
import my.test.Task.Management.System.Enum.TaskStatus;
import my.test.Task.Management.System.Enum.Priority;

@Getter
@Setter
public class TaskUpdateRequest {
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private Long assigneeId;


}