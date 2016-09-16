package app.component;

import def.angular.core.Component;
import jsweet.lang.Array;
import def.primeng.primeng.DataListModule;

@Component(
  selector = "tasks",
  templateUrl = "app/tasks.component.html"
)
public class TaskComponent {

  private Array<Task> tasks;

  public TaskComponent() {
    tasks = new Array<>();
    for (int i = 0; i < 10; i++) {
      tasks.push(new Task("task" + i, "foo", "Read Java EE MVC 1.0 Spec", true));
    }
  }

  public Array<Task> getTasks() {
    return tasks;
  }

  public void setTasks(Array<Task> tasks) {
    this.tasks = tasks;
  }
}
