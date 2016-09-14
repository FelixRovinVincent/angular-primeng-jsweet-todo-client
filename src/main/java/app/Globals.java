package app;

import static def.angular.platform_browser_dynamic.Globals.platformBrowserDynamic;

import app.module.AppModule;

import def.primeng.primeng.Button;

public class Globals {

	static {
	  String foo = "";
		platformBrowserDynamic().bootstrapModule(AppModule.class);
	}

}
