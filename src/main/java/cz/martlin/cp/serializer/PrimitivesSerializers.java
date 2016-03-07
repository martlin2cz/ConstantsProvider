package cz.martlin.cp.serializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Lists primitives translators.
 * 
 * @author martin
 *
 */
public class PrimitivesSerializers {

	private static final Map<Class<?>, PrimitiveValueSerializer<?>> serializers = initialize();

	private static Map<Class<?>, PrimitiveValueSerializer<?>> initialize() {
		Map<Class<?>, PrimitiveValueSerializer<?>> serializers = new HashMap<>();

		serializers.put(byte.class, new ByteSerializer());
		serializers.put(short.class, new ShortSerializer());
		serializers.put(int.class, new IntSerializer());
		serializers.put(long.class, new LongSerializer());
		serializers.put(float.class, new FloatSerializer());
		serializers.put(double.class, new DoubleSerializer());
		serializers.put(boolean.class, new BooleanSerializer());
		serializers.put(char.class, new CharSerializer());

		return serializers;
	}

	/**
	 * Lists serializer of primitive types.
	 * 
	 * @return
	 */
	public Map<Class<?>, PrimitiveValueSerializer<?>> list() {
		return serializers;
	}

	// /////////////////////////////////////////////////////////////////////////

	public static class CharSerializer extends PrimitiveValueSerializer<Character> {

		@Override
		public Character parseNonNull(String val) throws Exception {
			return val.charAt(0);
		}

	}

	public static class BooleanSerializer extends PrimitiveValueSerializer<Boolean> {

		private static final String TRUE = "true";
		private static final String FALSE = "false";

		@Override
		public String serialize(Boolean value) throws Exception {
			if (value == null) {
				return null;
			}
			if (value) {
				return TRUE;
			} else {
				return FALSE;
			}
		}

		@Override
		public Boolean parseNonNull(String val) throws Exception {
			if (TRUE.equalsIgnoreCase(val)) {
				return true;
			} else if (FALSE.equalsIgnoreCase(val)) {
				return false;
			} else {
				throw new IllegalArgumentException("Not a boolean: " + val);
			}
		}

	}

	public static class DoubleSerializer extends PrimitiveValueSerializer<Double> {

		@Override
		public Double parseNonNull(String val) throws Exception {
			return Double.parseDouble(val);
		}

	}

	public static class FloatSerializer extends PrimitiveValueSerializer<Float> {

		@Override
		public Float parseNonNull(String val) throws Exception {
			return Float.parseFloat(val);
		}

	}

	public static class LongSerializer extends PrimitiveValueSerializer<Long> {

		@Override
		public Long parseNonNull(String val) throws Exception {
			return Long.parseLong(val);
		}

	}

	public static class IntSerializer extends PrimitiveValueSerializer<Integer> {

		@Override
		public Integer parseNonNull(String val) throws Exception {
			return Integer.parseInt(val);
		}

	}

	public static class ShortSerializer extends PrimitiveValueSerializer<Short> {

		@Override
		public Short parseNonNull(String val) throws Exception {
			return Short.parseShort(val);
		}

	}

	public static class ByteSerializer extends PrimitiveValueSerializer<Byte> {

		@Override
		public Byte parseNonNull(String val) throws Exception {
			return Byte.parseByte(val);
		}

	}

}
