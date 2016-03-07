package cz.martlin.cp.serializer;

/**
 * Extended serializer. In addition of {@link BaseSerializer}, can process more
 * than one type. This is guaranteed by method {@link #isApplicableTo(Class)}.
 * 
 * @author martin
 *
 * @param <T>
 */
public interface ExtendedSerializer<T> extends BaseSerializer<T> {
	/**
	 * Returns true if is this serializer applicable to (can process) given
	 * type.
	 * 
	 * @param type
	 * @return
	 */
	public abstract boolean isApplicableTo(Class<?> type);

}
