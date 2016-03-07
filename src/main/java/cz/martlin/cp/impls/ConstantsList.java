package cz.martlin.cp.impls;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.martlin.cp.constants.Constant;
import cz.martlin.cp.serializer.Serializers;

/**
 * List of constant's values and their getting, setting, serializing and
 * deserializing.
 * 
 * @author martin
 *
 */
public class ConstantsList {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private final Serializers serializers = new Serializers();
	private final ConstantsIO io;
	private Map<String, String> constants;

	public ConstantsList(ConstantsIO io) {
		this.io = io;
		this.constants = null;

	}

	/**
	 * Gets constant instance of given name in given class and of given type.
	 * 
	 * @param name
	 * @param inClazz
	 * @param type
	 * @return
	 */
	public <T> Constant<T> get(String name, Class<?> inClazz, Class<T> type) {
		String key = constructKey(name, inClazz);
		if (key == null) {
			return null;
		}

		String value = getValueOf(key);
		if (value == null) {
			return null;
		}

		Constant<T> converted = convert(value, type);
		if (converted == null) {
			return null;
		}

		return converted;
	}

	/**
	 * Returns value by {@link #get(String, Class, Class)} or default if cannot
	 * be read.
	 * 
	 * @param name
	 * @param inClazz
	 * @param type
	 * @param dflt
	 * @return
	 */
	public <T> T getOrDefault(String name, Class<?> inClazz, Class<T> type, T dflt) {
		Constant<T> constant = get(name, inClazz, type);

		if (constant != null) {
			log.info("Found value [{}] of constant [{}] in [{}]", constant.getValue(), name, inClazz.getName());
			return constant.getValue();
		} else {
			log.info("Not found or found invalid value of constant [{}] in [{}], using default [{}] instead", name,
					inClazz.getName(), dflt);
			return dflt;
		}
	}

	/**
	 * Converts given string value to object of given type.
	 * 
	 * @param string
	 * @param type
	 * @return
	 */
	public <T> Constant<T> convert(String string, Class<T> type) {
		try {
			T value = serializers.parse(type, string);
			return new Constant<>(value);
		} catch (Exception e) {
			log.warn("Value [{}] of type [{}] could not be converted.", string, type.getName());
			return null;
		}
	}

	/**
	 * Returns string value of given constant key.
	 * 
	 * @param key
	 * @return
	 */
	public String getValueOf(String key) {
		if (constants == null) {
			load();
		}

		String string = constants.get(key);
		if (string == null) {
			log.warn("Value of entry [{}] not found", key);
			return null;
		} else {
			return string;
		}
	}

	/**
	 * Construct constant key of given name of constant in given class.
	 * 
	 * @param name
	 * @param inClazz
	 * @return
	 */
	public String constructKey(String name, Class<?> inClazz) {
		String key = inClazz.getName() + "." + name;

		return key;
	}

	/**
	 * Sets given (dflt) value of constant of given name in given class and of
	 * given type.
	 * 
	 * @param name
	 * @param inClazz
	 * @param type
	 * @param dflt
	 * @return
	 */
	public <T> T setDefault(String name, Class<?> inClazz, Class<T> type, T dflt) {
		String key = constructKey(name, inClazz);
		if (key == null) {
			return null;
		}

		String converted = convert(dflt, type);

		setValueOf(key, converted);
		log.info("Value [{}] of type [{}] of constant [{}] in [{}] ready to be exported", dflt, type.getName(), name,
				inClazz.getName());

		return dflt;
	}

	/**
	 * Converts given object of given type to string.
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	private <T> String convert(T value, Class<T> type) {
		try {
			String string = serializers.serialize(type, value);
			return string;
		} catch (Exception e) {
			log.warn("Value [{}] of type [{}] could not be serialized.", value, type.getName());
			return null;
		}
	}

	/**
	 * Sets value of given constant key to given value.
	 * 
	 * @param key
	 * @param value
	 */
	private void setValueOf(String key, String value) {
		if (constants == null) {
			constants = new HashMap<>();
		}

		constants.put(key, value);
	}

	/**
	 * Loads from {@link #io}.
	 */
	public void load() {
		log.info("Loading constants");
		try {
			constants = io.load();
		} catch (IOException e) {
			log.error("Constants could not load: {}. Cause: " + e);
			return;
		}
		log.info("Constants successfully loaded");
	}

	/**
	 * Saves to {@link #io}.
	 */
	public void save() {
		log.info("Saving constants");
		try {
			io.save(constants);
		} catch (IOException e) {
			log.error("Constants could not save: {}. Cause: " + e);
			return;
		}
		log.info("Constants successfully saved");
	}

	@Override
	public String toString() {
		return "ConstantsList [constants=" + new TreeMap<>(constants) + "]";
	}

}
