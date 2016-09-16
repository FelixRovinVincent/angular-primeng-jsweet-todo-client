package app.module;

import app.component.AppComponent;
import def.angular.core.NgModule;
import def.angular.platform_browser.BrowserModule;
import def.primeng.primeng.ButtonModule;
import app.component.TaskComponent;
import def.primeng.primeng.DataListModule;

@NgModule(
	  imports = { BrowserModule.class, ButtonModule.class, DataListModule.class },
	  declarations = { AppComponent.class, TaskComponent.class },
	  bootstrap = { AppComponent.class }
	)
public class AppModule {

}
