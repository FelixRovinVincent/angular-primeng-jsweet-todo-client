package app.module;

import app.component.AppComponent;
import def.angular.core.NgModule;
import def.angular.platform_browser.BrowserModule;
import def.primeng.primeng.ButtonModule;
import app.component.TaskComponent;

@NgModule(
	  imports = { BrowserModule.class, ButtonModule.class },
	  declarations = { AppComponent.class, TaskComponent.class },
	  bootstrap = { AppComponent.class }
	)
public class AppModule {

}
