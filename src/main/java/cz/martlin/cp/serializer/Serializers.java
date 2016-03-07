package cz.martlin.cp.serializer;

import java.awt.Color;
import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.martlin.cp.ccs.BigDecimalCC;
import cz.martlin.cp.ccs.CalendarCC;
import cz.martlin.cp.ccs.ColorCC;
import cz.martlin.cp.ccs.DateCC;
import cz.martlin.cp.ccs.EnumsCC;
import cz.martlin.cp.ccs.FileCC;
import cz.martlin.cp.ccs.StringsCC;
import cz.martlin.cp.ccs.URLCC;

/**
 * Lists all supported serializers and allows to search within.
 * 
 * @author martin
 *
 */
public class Serializers {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private final Map<Class<?>, SimpleSerializer<?>> simple = initSimple();
	private final List<ExtendedSerializer<?>> extended = initExtended();

	public Serializers() {
	}

	/**
	 * Initializes simple serializers.
	 * 
	 * @return
	 */
	private Map<Class<?>, SimpleSerializer<?>> initSimple() {
		Map<Class<?>, SimpleSerializer<?>> serializers = new HashMap<>();

		PrimitivesSerializers primitives = new PrimitivesSerializers();
		for (Entry<Class<?>, PrimitiveValueSerializer<?>> entry : primitives.list().entrySet()) {
			serializers.put(entry.getKey(), entry.getValue());
		}

		serializers.put(BigDecimal.class, new BigDecimalCC.BigDecimalSerializer());
		serializers.put(Calendar.class, new CalendarCC.CalendarSerializer());
		serializers.put(Color.class, new ColorCC.ColorSerializer());
		serializers.put(Date.class, new DateCC.DateSerializer());
		serializers.put(File.class, new FileCC.FileSerializer());
		serializers.put(String.class, new StringsCC.StringsSerializer());
		serializers.put(URL.class, new URLCC.URLSerializer());

		// TODO

		return serializers;
	}

	/**
	 * Initializes extended serializers.
	 * 
	 * @return
	 */
	private List<ExtendedSerializer<?>> initExtended() {
		List<ExtendedSerializer<?>> serializers = new ArrayList<>();

		serializers.add(new EnumsCC.EnumsSerializer<>());

		return serializers;
	}

	/**
	 * Find serializer for given type.
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> BaseSerializer<T> find(Class<T> type) {
		BaseSerializer<T> simple = (BaseSerializer<T>) this.simple.get(type);
		if (simple != null) {
			return simple;
		}

		for (ExtendedSerializer<?> extended : this.extended) {
			if (extended.isApplicableTo(type)) {
				return (BaseSerializer<T>) extended;
			}
		}

		log.error("Unsupported type [" + type.getName() + "]");
		return null;
	}

	/**
	 * Serializes given value of given type.
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public <T> String serialize(Class<T> type, T value) throws Exception {
		BaseSerializer<T> serializer = find(type);
		if (serializer == null) {
			return null;
		} else {
			return serializer.serialize(type, value);
		}
	}

	/**
	 * Parses given value of given type into object.
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public <T> T parse(Class<T> type, String value) throws Exception {
		BaseSerializer<T> serializer = find(type);
		if (serializer == null) {
			return null;
		} else {
			return serializer.parse(type, value);
		}
	}

	/**
	 * Lists all supported serializers.
	 * 
	 * @return
	 */
	public List<BaseSerializer<?>> listSerializers() {
		List<BaseSerializer<?>> all = new ArrayList<>();

		all.addAll(simple.values());
		all.addAll(extended);

		return all;
	}
}
