package app.component;

import app.service.TaskService;
import def.angular.core.Component;
import def.primeng.primeng.Message;
import jsweet.lang.Array;

@Component(
  selector = "tasks",
  templateUrl = "app/tasks.component.html"
)
public class TasksComponent {

  private jsweet.lang.Array<Task> tasks;
  private TaskService taskService;
  private Message[] messages;

  //  public TasksComponent() {
  public TasksComponent(TaskService taskService) {
    this.taskService = taskService;
//    tasks = new Task[10];
//    for (int i = 0; i < 10; i++) {
//      tasks.push(new Task("task" + i, "foo", "Read Java EE MVC 1.0 Spec", true));
//    }
  }

  public void ngOnInit() {
    refreshTasks(false);
  }

  public void refreshTasks(boolean showMessages) {
    this.taskService.getTasks().thenOnFulfilledFunction(tasks -> {
      this.tasks = tasks;
      if (showMessages) {
        addMessage("info", "Tasks refreshed successfully.", null);
      }
      return tasks;
    });
  }

  public Array<Task> getTasks() {
    return tasks;
  }

  public void save(int index, Task task) {
    if (task.getId() == null) {
      this.taskService.add(task).thenOnFulfilledFunction((res) -> {
        addMessage("info", "Task added successfully.", null);
        this.tasks.$set(String.valueOf(index), task);
        return task;
      });
    } else {
      // TODO: Add a growl notification or something
      this.taskService.update(task).thenOnFulfilledFunction((res) -> {
        addMessage("info", "Task updated successfully.", null);
        return res;
      });
    }
  }

  public void add(Task task) {
//    this.taskService.add(task).thenOnFulfilledFunction((res) -> {
//      addMessage("info", "Task updated successfully.", null);
//      return task;
//    });
      tasks.unshift(new Task(null, "you", "", false));
  }

  private void addMessage(String sev, String sum, String dtl) {
    this.messages = new Message[]{new Message() {
      {
        severity = sev;
        summary = sum;
        detail = dtl;
      }
    }};
  }

}
