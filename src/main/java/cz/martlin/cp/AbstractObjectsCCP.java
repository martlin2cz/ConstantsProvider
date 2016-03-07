package cz.martlin.cp;

import cz.martlin.cp.ccs.BigDecimalCC;
import cz.martlin.cp.ccs.ColorCC;
import cz.martlin.cp.ccs.EnumsCC;
import cz.martlin.cp.ccs.FileCC;
import cz.martlin.cp.ccs.StringsCC;
import cz.martlin.cp.ccs.URLCC;

/**
 * Object types object constants creators provider.
 * 
 * @see ConstantCreator
 * @author martlin
 *
 */
public interface AbstractObjectsCCP {
	public StringsCC string();

	public EnumsCC<?> enums();

	public FileCC file();

	public URLCC url();

	public BigDecimalCC bigDecimal();

	public ColorCC color();

	public <T> T get(String name, Class<T> type, T dflt);

}
