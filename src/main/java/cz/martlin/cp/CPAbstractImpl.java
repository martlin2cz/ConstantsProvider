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
 * Base abstract implementation of providing constant's values. 
 * 
 * @see CP
 * 
 * @author martin
 *
 */
public abstract class CPAbstractImpl implements AbstractPrimitiveCP, AbstractObjectsCCP {

	private static final String CP_CLASS_NAME_PREFIX = CPAbstractImpl.class.getPackage().getName() + ".";

	private final StringsCC string;
	private final EnumsCC<?> enums;
	private final FileCC file;
	private final URLCC url;
	private final CalendarCC calendar;
	private final DateCC date;
	private final BigDecimalCC bigDecimal;
	private final ColorCC color;

	public CPAbstractImpl() {
		string = new StringsCC(this);
		enums = new EnumsCC<>(this);
		file = new FileCC(this);
		url = new URLCC(this);
		calendar = new CalendarCC(this);
		date = new DateCC(this);
		bigDecimal = new BigDecimalCC(this);
		color = new ColorCC(this);
	}

	public abstract byte get(String name, byte dflt);

	public abstract short get(String name, short dflt);

	public abstract int get(String name, int dflt);

	public abstract long get(String name, long dflt);

	public abstract float get(String name, float dflt);

	public abstract double get(String name, double dflt);

	public abstract char get(String name, char dflt);

	public abstract boolean get(String name, boolean dflt);

	public StringsCC string() {
		return string;
	}

	public EnumsCC<?> enums() {
		return enums;
	}

	public FileCC file() {
		return file;
	}

	public URLCC url() {
		return url;
	}

	public DateCC date() {
		return date;
	}

	public CalendarCC calendar() {
		return calendar;
	}

	public BigDecimalCC bigDecimal() {
		return bigDecimal;
	}

	public ColorCC color() {
		return color;
	}

	/**
	 * Returns first class on current (thread's) stack, which is not part of CP
	 * library.
	 * 
	 * @return
	 */
	public static Class<?> getCallee() {
		try {
			StackTraceElement trace[] = Thread.currentThread().getStackTrace();

			for (StackTraceElement element : trace) {
				String method = element.getMethodName();
				if ("getStackTrace".equals(method)) {
					continue;
				}

				String callee = element.getClassName();

				if (!callee.startsWith(CP_CLASS_NAME_PREFIX)) {
					Class<?> clazz = Class.forName(callee);
					return clazz;
				}
			}

			return null;
		} catch (Exception e) {
			return null;
		}
	}

}