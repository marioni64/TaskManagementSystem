//package my.test.Task.Management.System.Service;
//
//import my.test.Task.Management.System.DTO.TaskUpdateRequest;
//import my.test.Task.Management.System.TaskManagement.Task;
//import my.test.Task.Management.System.TaskManagement.TaskRepository;
//import my.test.Task.Management.System.TaskNotFoundException;
//import my.test.Task.Management.System.Usr.UserService;
//import my.test.Task.Management.System.Enum.TaskStatus;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TaskService {
//
//    private final TaskRepository taskRepository;
//    private final UserService userService;
//
//    @Autowired
//    public TaskService(TaskRepository taskRepository, UserService userService) {
//        this.taskRepository = taskRepository;
//        this.userService = userService;
//    }
//
//    @PreAuthorize("hasRole('ADMIN') || @taskSecurity.isTaskAuthor(authentication, #taskId)")
//    public Task updateTask(Long taskId, TaskUpdateRequest request) {
//        Task task = taskRepository.findById(taskId)
//                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
//
//        task.setTitle(request.getTitle());
//        task.setDescription(request.getDescription());
//        task.setStatus(request.getStatus());
//        task.setPriority(request.getPriority());
//
//        if (request.getAssigneeId() != null) {
//            task.setAssignee(userService.getUserById(request.getAssigneeId()));
//        }
//
//        return taskRepository.save(task);
//    }
//
//    public Page<Task> getFilteredTasks(Long authorId, Long assigneeId, TaskStatus status, Pageable pageable) {
//        return taskRepository.findFilteredTasks(authorId, assigneeId, status, pageable);
//    }
//}