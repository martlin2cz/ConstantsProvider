package cz.martlin.cp.ccs;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.ConstantCreator;
import cz.martlin.cp.serializer.SimpleSerializer;

public class StringsCC extends ConstantCreator<String> {

	public StringsCC(CPAbstractImpl impl) {
		super(impl, String.class, new StringsSerializer());
	}

	public static class StringsSerializer extends SimpleSerializer<String> {

		@Override
		public String parse(String value) throws Exception {
			return value;
		}

		@Override
		public String serialize(String value) throws Exception {
			return value;
		}

	}

}
