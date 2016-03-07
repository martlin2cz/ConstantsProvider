package cz.martlin.cp.serializer;

/**
 * Serializes and deserializes value of one type. Which and how - that's the
 * question.
 * 
 * @author martlin
 *
 * @param <T>
 */
public interface BaseSerializer<T> {
	/**
	 * Parses value from given string.
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public abstract T parse(Class<T> type, String value) throws Exception;

	/**
	 * Serializes given value to string.
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public abstract String serialize(Class<T> type, T value) throws Exception;

}
