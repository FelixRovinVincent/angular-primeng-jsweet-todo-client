package app.component;

import app.service.TaskService;
import def.angular.core.Component;
import jsweet.lang.Array;
import def.primeng.primeng.DataListModule;

@Component(
  selector = "tasks",
  templateUrl = "app/tasks.component.html"
)
public class TasksComponent {

  private Task[] tasks;
  private TaskService taskService;

//  public TasksComponent() {
  public TasksComponent(TaskService taskService) {
    this.taskService = taskService;
//    tasks = new Task[10];
//    for (int i = 0; i < 10; i++) {
//      tasks.push(new Task("task" + i, "foo", "Read Java EE MVC 1.0 Spec", true));
//    }
  }

  public void ngOnInit() {
    this.taskService.getTasks().thenOnFulfilledFunction(tasks -> {
      this.tasks = tasks;
      return tasks;
    });
  }

  public Task[] getTasks() {
    return tasks;
  }

}
