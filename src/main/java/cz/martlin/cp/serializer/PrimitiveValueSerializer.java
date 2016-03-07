package cz.martlin.cp.serializer;

/**
 * Serializer of primitive type value.
 * 
 * @author martin
 *
 * @param <T>
 */
public abstract class PrimitiveValueSerializer<T> extends SimpleSerializer<T> {

	public PrimitiveValueSerializer() {
	}

	@Override
	public T parse(String value) throws Exception {
		if (value.isEmpty()) {
			return null;
		} else {
			return parseNonNull(value);
		}
	}

	/**
	 * Parses value which cannot be null.
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public abstract T parseNonNull(String value) throws Exception;

	@Override
	public String serialize(T value) throws Exception {
		return String.valueOf(value);
	}
}
