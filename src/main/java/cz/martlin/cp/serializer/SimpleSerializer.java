package cz.martlin.cp.serializer;

/**
 * Converts simply only and only values of type T.
 * 
 * @author martlin
 *
 * @param <T>
 */
public abstract class SimpleSerializer<T> implements BaseSerializer<T> {

	public SimpleSerializer() {
	}

	@Override
	public T parse(Class<T> type, String value) throws Exception {
		return parse(value);
	}

	/**
	 * Parses value from given string.
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public abstract T parse(String value) throws Exception;

	@Override
	public String serialize(Class<T> type, T value) throws Exception {
		return serialize(value);
	}

	/**
	 * Serializes given value to string.
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public abstract String serialize(T value) throws Exception;

}
