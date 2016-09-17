package app.module;

import app.component.AppComponent;
import app.component.TasksComponent;
import app.service.TaskService;
import def.angular.core.NgModule;
import def.angular.forms.FormsModule;
import def.angular.http.HttpModule;
import def.angular.platform_browser.BrowserModule;
import def.primeng.primeng.ButtonModule;
import def.primeng.primeng.DataListModule;
import def.primeng.primeng.InputTextModule;
import def.primeng.primeng.PanelModule;
import def.primeng.primeng.GrowlModule;
import def.primeng.primeng.ToolbarModule;
import def.primeng.primeng.CheckboxModule;


@NgModule(
  imports = {
    BrowserModule.class,
    ButtonModule.class,
    DataListModule.class,
    InputTextModule.class,
    PanelModule.class,
    HttpModule.class,
    FormsModule.class,
    GrowlModule.class,
    ToolbarModule.class,
    CheckboxModule.class
  },
  declarations = {
    AppComponent.class,
    TasksComponent.class
  },
  bootstrap = {AppComponent.class},
  providers = {TaskService.class}
)
public class AppModule {

}
