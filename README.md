# ConstantsProvider

Simple library for managing your projects constants. What should be better than having all the constants in one .properties file instead of having them hardcoded in classes?

## Principle
Consider class like this:
```java
public class WebAppConfig {
	public final int PORT = 80;
	public final String HOST = "localhost";
	public final File CONFIG = new File("config.xml");

	//...
}
```
This code has some obvious disadvantages. The main - for change of the configuration is required to rebuild and repack whole project (assuming usage of maven). On the second hand - "Where did I store the format of date of export format? Did I put it inside the web app config class or - into export class? Or somewhere else?". So, look at this:
```java
public class AppConfig {
	public final int PORT = CP.get("port", 80);
	public final String HOST = CP.string().create("host", "localhost");
	public final File CONFIG = CP.file().parse("cfg", "config.xml");

	//...

}
```
I know, it looks much worse. But, you can generate file named `constants.properties` and simply modify values there. So, the file could look like this:
```properties
\#ConstantsProvider constants file 
com.company.project.WebAppConfig.port=8080
com.company.project.WebAppConfig.host=192.168.0.11
com.company.project.WebAppConfig.cfg=testing-config.xml
```  
By simple modification of file `constants.properties` (or, obviously, your custom) you can change the behavior of application without rebuild (unfortunatelly, restart is still required). Or you can just simply disable constants file usage and use provided default values.

See `/constants-provider/src/test/java/cz/martlin/cp/Demo.java` for demo app and basic usage.

## TODO
- [ ] test
- [ ] implement some more `ConstantsProvider`s.
- [ ] add support of arrays, collections, and maps? And - add support of complex objects? Use [jaxon](http://github.com/martlin2cz/jaxon)? 