package app.module;

import app.component.AppComponent;
import def.angular.core.NgModule;
import def.angular.platform_browser.BrowserModule;
import def.primeng.primeng.Button;

@NgModule(
	  imports = { BrowserModule.class, Button.class },
	  declarations = { AppComponent.class },
	  bootstrap = { AppComponent.class }
	)
public class AppModule {

}
