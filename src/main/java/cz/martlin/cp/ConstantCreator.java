package cz.martlin.cp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.martlin.cp.serializer.BaseSerializer;

/**
 * Abstract constant creator. Creator works with some object type T (Date,
 * Color, URL, ...) and allows to load instance by {@link CPAbstractImpl} and -
 * by some simple way - create default instances. So, you can create defualt
 * value directly ({@link #create(String, Object)}) or parse (
 * {@link #parse(String, String)} ). The subclass can add lots of custom (like
 * construct color from R,G and B ints).
 * 
 * @author martlin
 *
 * @param <T>
 */
public abstract class ConstantCreator<T> {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private final CPAbstractImpl impl;
	private final Class<T> type;
	private final BaseSerializer<T> serializer;

	public ConstantCreator(CPAbstractImpl impl, Class<T> type, BaseSerializer<T> serializer) {
		this.impl = impl;
		this.type = type;
		this.serializer = serializer;
	}

	public T create(String name, T dflt) {
		return impl.get(name, type, dflt);
	}

	public T parse(String name, String dflt) {
		T dfltVal;
		try {
			dfltVal = serializer.parse(type, dflt);
		} catch (Exception e) {
			log.error("Cannot create default value of type [" + type.getName() + "] from string [" + dflt
					+ "]. Assuming null. Cause: " + e);
			return null;
		}
		return create(name, dfltVal);
	}

}
