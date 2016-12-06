package app.component;

import app.service.TaskService;
import def.angular.core.Component;
import def.primeng.primeng.Message;
import jsweet.lang.Array;

import static jsweet.dom.Globals.console;

@Component(
  selector = "tasks",
  templateUrl = "app/tasks.component.html"
)
public class TasksComponent {

  private jsweet.lang.Array<Task> tasks;
  private TaskService taskService;
  private Message[] messages;

  public TasksComponent(TaskService taskService) {
    this.taskService = taskService;
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
      this.taskService.update(task).thenOnFulfilledFunction((res) -> {
        addMessage("info", "Task updated successfully.", null);
        return res;
      });
    }
  }

  public void remove(int index, Task task) {
    console.debug("task", task, task.getId());
    if (task.getId() == null) {
      removeFromArray(index, task);
    } else {
      this.taskService.remove(task).thenOnFulfilledFunction((res) -> {
        removeFromArray(index, task);
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

  private void removeFromArray(int index, Task task) {
    addMessage("info", "Task deleted successfully.", null);
    tasks.splice(index, 1);
  }

}
