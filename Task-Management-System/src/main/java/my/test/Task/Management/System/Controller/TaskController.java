//package my.test.Task.Management.System.Controller;
//
//
//import my.test.Task.Management.System.DTO.TaskCreateRequest;
//import my.test.Task.Management.System.DTO.TaskResponse;
//import my.test.Task.Management.System.DTO.TaskUpdateRequest;
//import my.test.Task.Management.System.Enum.TaskStatus;
//import my.test.Task.Management.System.Service.TaskService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/tasks")
//public class TaskController {
//
//    private final TaskService taskService;
//
//    public TaskController(TaskService taskService) {
//        this.taskService = taskService;
//    }
//
//    // Создать задачу (только админ)
//    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskCreateRequest request) {
//        return ResponseEntity.ok(taskService.createTask(request));
//    }
//
//    // Получить задачи с фильтрацией
//    @GetMapping
//    public ResponseEntity<Page<TaskResponse>> getTasks(
//            @RequestParam(required = false) Long authorId,
//            @RequestParam(required = false) Long assigneeId,
//            @RequestParam(required = false) TaskStatus status,
//            Pageable pageable
//    ) {
//        return ResponseEntity.ok(taskService.getFilteredTasks(authorId, assigneeId, status, pageable));
//    }
//
//    // Получить задачу по ID
//    @GetMapping("/{taskId}")
//    public ResponseEntity<TaskResponse> getTask(@PathVariable Long taskId) {
//        return ResponseEntity.ok(taskService.getTaskById(taskId));
//    }
//
//    // Обновить задачу (админ или автор)
//    @PutMapping("/{taskId}")
//    @PreAuthorize("hasRole('ADMIN') || @taskSecurity.isTaskAuthor(authentication, #taskId)")
//    public ResponseEntity<TaskResponse> updateTask(
//            @PathVariable Long taskId,
//            @RequestBody TaskUpdateRequest request
//    ) {
//        return ResponseEntity.ok(taskService.updateTask(taskId, request));
//    }
//
//    // Удалить задачу (только админ)
//    @DeleteMapping("/{taskId}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
//        taskService.deleteTask(taskId);
//        return ResponseEntity.noContent().build();
//    }
//}
