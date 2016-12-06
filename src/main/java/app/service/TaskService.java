package app.service;

import app.component.Task;
import def.angular.core.Injectable;
import def.angular.http.Headers;
import def.angular.http.Http;
import def.angular.http.RequestOptionsArgs;
import def.angular.http.Response;
import def.es6_promise.Promise;
import jsweet.lang.Array;
import jsweet.lang.JSON;

import static jsweet.util.Globals.$get;

/**
 * Simple class for retreiving and updating tasks.
 * <p>
 * Created: 16 Sep 2016
 *
 * @author Kito D. Mann
 */
@Injectable
public class TaskService {

  private Http http;
  private static String url = "http://localhost:8081/todo/tasks/";

  public TaskService(Http http) {
    this.http = http;
  }

  public Promise<Array<Task>> getTasks() {
    return this.http.get(TaskService.url + "list/").toPromise()
      .thenOnFulfilledFunction(res -> {
        Object[] jsonTasks = (Object[]) res.json();
        Array<Task> tasks = new Array<>();
        for (int i = 0; i < jsonTasks.length; i++) {
          tasks.push(new Task($get(jsonTasks[i], "id"), $get(jsonTasks[i], "userId"),
            $get(jsonTasks[i], "name"), $get(jsonTasks[i], "completed")));
        }
        return tasks;
      })
      .thenOnFulfilledFunction(data -> {
          return data;
        }
      );
  }

  public Promise<Task> add(Task task) {
    String body = JSON.stringify(task);
    return this.http.post(TaskService.url + "add", body, getRequestOptions())
      .toPromise()
      .thenOnFulfilledFunction(res -> {
        Object jsonTask = res.json();
        return new Task($get(jsonTask, "id"), $get(jsonTask, "userId"), $get(jsonTask, "name"), $get(jsonTask, "completed"));
      });
  }

  public Promise<Response> update(Task task) {
    String body = JSON.stringify(task);
    return this.http.put(TaskService.url + task.getId(), body, getRequestOptions()).toPromise()
      .thenOnFulfilledFunction(res -> {
        return res;
      });
  }

  public Promise<Response> remove(Task task) {
    return this.http.delete(TaskService.url + task.getId()).toPromise();
  }

  private RequestOptionsArgs getRequestOptions() {
    Headers headers = new Headers();
    headers.append("Content-Type", "application/json");
    RequestOptionsArgs options = new RequestOptionsArgs(null, null, null, headers, null, false);
    return options;
  }

}
