package cz.martlin.cp.constants;

/**
 * Represents constant, i.e. its value.
 * 
 * @author martlin
 *
 * @param <T>
 */
public class Constant<T> {
	private final T value;

	public Constant(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Constant<?> other = (Constant<?>) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Constant [value=" + value + "]";
	}

}
