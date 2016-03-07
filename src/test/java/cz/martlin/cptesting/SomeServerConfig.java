package cz.martlin.cptesting;

import java.io.File;
import java.net.URL;

import cz.martlin.cp.CP;

/**
 * Some testing class.
 * 
 * @author martin
 *
 */
public class SomeServerConfig {
	public final int PORT = CP.get("port", 90);
	public final String HOST = CP.string().create("host", "localhost");
	public final File CONFIG = CP.file().parse("cfg", "config.xml");
	public final File LOGFILE = CP.file().create("logfile", new File("log.log"));
	public final URL HOMEPAGE = CP.url().parse("home", "http://localhost/home");
	public final AdminUserData ADMIN = new AdminUserData();

	public SomeServerConfig() {
	}

	@Override
	public String toString() {
		return "SomeServerConfig [PORT=" + PORT + ", HOST=" + HOST + ", CONFIG=" + CONFIG + ", LOGFILE=" + LOGFILE
				+ ", HOMEPAGE=" + HOMEPAGE + ", ADMIN=" + ADMIN + "]";
	}

}
