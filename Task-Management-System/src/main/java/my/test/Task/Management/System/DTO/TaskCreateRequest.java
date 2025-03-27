package my.test.Task.Management.System.DTO;

//import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import my.test.Task.Management.System.Enum.Priority;

@Getter
@Setter
public class TaskCreateRequest {
//    @NotBlank
    private String title;
    private String description;
    private Priority priority;
    private Long assigneeId;
}
