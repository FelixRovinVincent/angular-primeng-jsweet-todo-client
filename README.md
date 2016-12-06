# Example Todo app built with Angular 2, PrimeNG, and Java (using JSweet on the front-end and JAX-RS on the back-end)

This is part of the sample application for the presentation "Full Stack Java with JSweet, Angular 2, PrimeNG, and JAX-RS", 
originally given at JavaOne in September, 2016 by [Kito D. Mann](https://www.linkedin.com/in/kitomann) from [Virtua, Inc.](https://virtua.tech). It demonstrates how you 
can write an [Angular 2](https://angular.io) application with [PrimeNG](http://www.primefaces.org/primeng/) components using Java (courtesy of the
 [JSweet](http://jsweet.org) transpiler), and have it talk to a standard Java back-end using [JAX-RS](https://jax-rs-spec.java.net/).

This repository contains the front-end code; the [back-end](https://github.com/kito99/angular-primeng-jsweet-todo-server) and 
[slides](https://github.com/kito99/angular-primeng-jsweet-todo-slides) are in separate repositories. 

This project was forked from the [Angular 2 Quickstart with Java](https://github.com/cincheo/jsweet-angular2-quickstart); see that project for a simpler example without a back-end. 
There is also a [JSweet PrimeNG Quickstart](https://github.com/cincheo/jsweet-primeng-quickstart) project available without a back-end.  

**Special thanks to [Renaud Pawlak](https://github.com/renaudpawlak) (JSweet lead developer) for his extensive assistance with getting this project working!**

>NOTE: This project uses the [Angular 2.0RC5](https://github.com/jsweet-candies/candy-angular2) and [PrimeNG 1.0.0-beta.14](https://github.com/jsweet-candies/candy-primeng) JSweet candies. In order to upgrade 
 to newer versions, those candies must be manually upgraded. If you do that, please create a pull request!

## Prerequisites

Node.js > v4.x.x and npm > v3.x.x. 
    
**Verify that you are running at least node `v4.x.x` and npm `3.x.x`**
by running `node -v` and `npm -v` in a terminal/console window.
Older versions produce errors.

Maven (for compiling with JSweet).

## Getting started

Clone the project.

```bash
git clone  https://github.com/cincheo/jsweet-Angular 2-quickstart my-proj
cd my-proj
```

Compile JSweet sources (located in: ``src/main/java``).

```bash
mvn generate-sources
```

> Note: you can also use Eclipse to compile (see the JSweet Eclipse plugin).

Install the npm packages described in the `package.json` and verify that it works:

**Attention Windows Developers:  You must run all of these commands in administrator mode**.

```bash
npm install
npm start
```

This will open the application in your browser. If you compile again the Java source files, the application will automatically reload. Shut it down manually with Ctrl-C.

NOTE: If you have problems compiling `fileupload.d.ts`, edit the file and replace all references to `DomSanitize` with `DomSanitizationService`. 
This appears to be a bug with the version of PrimeNG used in the project.

### How to extend the application

You can add new classes in the ``app`` package (``src/main/java``). Please be aware that in JSweet, each package is a module. So, all the classes defined in a given package will belong to the same TypeScript/JavaScript module.

New templates should be placed in the ``app`` folder. 

A minimal Angular 2 API is defined in the ``def.angular`` package (the ``def`` package in JSweet is by convention similar to a ``d.ts`` file in TypeScript: it holds external declarations). 
When extending the application, you will need to provide the API elements that you are using and that would be missing in the current definitions.

If you want to use external JavaSript libraries, check out JSweet candies rather than writing definitions manually. Here definitions have to be written manually for Angular 2 because the corresponding candy does not exist yet.

### Setup the back-end

Visit the [angular-primeng-jsweet-todo-server](https://github.com/kito99/angular-primeng-jsweet-todo-server) project and clone the Java-based back-end built using Jersey and JAX-RS. 
See the README for that repository for more information.
