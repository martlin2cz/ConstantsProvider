package cz.martlin.cp;

import cz.martlin.cp.ccs.BigDecimalCC;
import cz.martlin.cp.ccs.CalendarCC;
import cz.martlin.cp.ccs.ColorCC;
import cz.martlin.cp.ccs.DateCC;
import cz.martlin.cp.ccs.EnumsCC;
import cz.martlin.cp.ccs.FileCC;
import cz.martlin.cp.ccs.StringsCC;
import cz.martlin.cp.ccs.URLCC;

/**
 * Constants provider.
 * 
 * @author martin
 *
 */
public class CP {

	private final static CPAbstractImpl impl;

	static {
		impl = initialize();
	}

	private CP() {
	}

	private static CPAbstractImpl initialize() {
		CPImplsInitializer init = new CPImplsInitializer();
		return init.getImpl();
	}

	/**
	 * Gets byte value of given name or default.
	 * 
	 * @param name
	 * @param dflt
	 * @return
	 */
	public static byte get(String name, byte dflt) {
		return impl.get(name, dflt);
	}

	/**
	 * Gets short value of given name or default.
	 * 
	 * @param name
	 * @param dflt
	 * @return
	 */
	public static short get(String name, short dflt) {
		return impl.get(name, dflt);
	}

	/**
	 * Gets int value of given name or default.
	 * 
	 * @param name
	 * @param dflt
	 * @return
	 */
	public static int get(String name, int dflt) {
		return impl.get(name, dflt);
	}

	/**
	 * Gets long value of given name or default.
	 * 
	 * @param name
	 * @param dflt
	 * @return
	 */
	public static long get(String name, long dflt) {
		return impl.get(name, dflt);
	}

	/**
	 * Gets float value of given name or default.
	 * 
	 * @param name
	 * @param dflt
	 * @return
	 */
	public static float get(String name, float dflt) {
		return impl.get(name, dflt);
	}

	/**
	 * Gets double value of given name or default.
	 * 
	 * @param name
	 * @param dflt
	 * @return
	 */
	public static double get(String name, double dflt) {
		return impl.get(name, dflt);
	}

	/**
	 * Gets char value of given name or default.
	 * 
	 * @param name
	 * @param dflt
	 * @return
	 */
	public static char get(String name, char dflt) {
		return impl.get(name, dflt);
	}

	/**
	 * Gets boolean value of given name or default.
	 * 
	 * @param name
	 * @param dflt
	 * @return
	 */
	public static boolean get(String name, boolean dflt) {
		return impl.get(name, dflt);
	}

	/**
	 * Gets string constant creator.
	 * 
	 * @return
	 */
	public static StringsCC string() {
		return impl.string();
	}

	/**
	 * Gets enums constant creator.
	 * 
	 * @return
	 */
	public static EnumsCC<?> enums() {
		return impl.enums();
	}

	/**
	 * Gets date constant creator.
	 * 
	 * @return
	 */
	public static DateCC date() {
		return impl.date();
	}

	/**
	 * Gets calendar constant creator.
	 * 
	 * @return
	 */
	public static CalendarCC calendar() {
		return impl.calendar();
	}

	/**
	 * Gets file constant creator.
	 * 
	 * @return
	 */
	public static FileCC file() {
		return impl.file();
	}

	/**
	 * Gets url constant creator.
	 * 
	 * @return
	 */
	public static URLCC url() {
		return impl.url();
	}

	/**
	 * Gets big decimal constant creator.
	 * 
	 * @return
	 */
	public static BigDecimalCC bigDecimal() {
		return impl.bigDecimal();
	}

	/**
	 * Gets color constant creator.
	 * 
	 * @return
	 */
	public static ColorCC color() {
		return impl.color();
	}

}
