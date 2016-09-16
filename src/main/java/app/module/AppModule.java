package app.module;

import app.component.AppComponent;
import app.component.TasksComponent;
import def.angular.core.NgModule;
import def.angular.http.HttpModule;
import def.angular.platform_browser.BrowserModule;
import def.primeng.primeng.ButtonModule;
import def.primeng.primeng.DataListModule;
import def.primeng.primeng.PanelModule;

@NgModule(
  imports = {
    BrowserModule.class,
    ButtonModule.class,
    DataListModule.class,
    PanelModule.class,
    HttpModule.class,
  },
  declarations = {
    AppComponent.class,
    TasksComponent.class
  },
  bootstrap = {AppComponent.class}
)
public class AppModule {

}
