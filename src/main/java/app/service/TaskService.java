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
  private static String url = "http://localhost:8080/tasks/";

  public TaskService(Http http) {
    this.http = http;
  }

  public Promise<Array<Task>> getTasks() {
    return this.http.get(TaskService.url + "/list/").toPromise()
      .thenOnFulfilledFunction(res -> new Array<>((Task[]) res.json()))
      .thenOnFulfilledFunction(data -> {
          return data;
        }
      );
  }

  public Promise<Task> add(Task task) {
    String body = JSON.stringify(task);
    return this.http.post(TaskService.url, body, getRequestOptions())
      .toPromise()
      .thenOnFulfilledFunction(res -> (Task) res.json());
  }

  public Promise<Task> update(Task task) {
    return this.http.patch(TaskService.url + "id", getRequestOptions()).toPromise()
      .thenOnFulfilledFunction(res -> (Task) res.json());
  }

  public Promise<Response> remove(String id) {
    return this.http.delete(TaskService.url + "id", getRequestOptions()).toPromise();
  }

  private RequestOptionsArgs getRequestOptions() {
    Headers headers = new Headers();
    headers.append("Content-Type", "application/json");
    return new RequestOptionsArgs(headers);
  }

}
