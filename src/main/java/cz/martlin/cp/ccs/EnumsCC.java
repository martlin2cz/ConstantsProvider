package cz.martlin.cp.ccs;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.ConstantCreator;
import cz.martlin.cp.serializer.ExtendedSerializer;

public class EnumsCC<T extends Enum<T>> extends ConstantCreator<T> {

	@SuppressWarnings("unchecked")
	public EnumsCC(CPAbstractImpl impl) {
		super(impl, (Class<T>) (Class<?>) Enum.class, new EnumsSerializer<>());
	}

	public static class EnumsSerializer<T extends Enum<T>> implements ExtendedSerializer<T> {
		public EnumsSerializer() {
		}

		@Override
		public T parse(Class<T> type, String value) throws Exception {
			return Enum.valueOf(type, value);
		}

		@Override
		public String serialize(Class<T> type, T value) throws Exception {
			return value.name();
		}

		@Override
		public boolean isApplicableTo(Class<?> type) {
			return type.isEnum();
		}

	}
}
