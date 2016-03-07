package cz.martlin.cp;

import cz.martlin.cptesting.SomeServerConfig;

/**
 * "Simple" demonstration application.
 * 
 * @author martlin
 *
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println("I am doing something awesome...");

		// [DEFAULT] sets to use default file (constants.properties) to load
		// constants from
		// System.setProperty(CPImplsInitializer.PROPERTY_NAME, null);

		// disables loading from constants file (uses only provided defaults
		// values)
		// System.setProperty(CPImplsInitializer.PROPERTY_NAME, "DISABLE");

		// exports all queried constants into tmp file - see logs for its name
		// System.setProperty(CPImplsInitializer.PROPERTY_NAME, "EXPORT");

		// sets file to load constants from given file
		// System.setProperty(CPImplsInitializer.PROPERTY_NAME,
		// "src/test/resources/server.props");
		// or another one
		// System.setProperty(CPImplsInitializer.PROPERTY_NAME,
		// "src/test/resources/server-full.props");

		SomeServerConfig server = new SomeServerConfig();
		System.out.println("Port: " + server.PORT);
		System.out.println("Host: " + server.HOST);
		System.out.println("Config file:	" + server.CONFIG);
		System.out.println("Logs file:	" + server.LOGFILE);
		System.out.println("Homepage:	" + server.HOMEPAGE);
		System.out.println("Admin:	" + server.ADMIN.toString().replace(", ", ",\n  "));
	}

}
