package cz.martlin.cp.ccs;

import java.net.URL;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.ConstantCreator;
import cz.martlin.cp.serializer.SimpleSerializer;

public class URLCC extends ConstantCreator<URL> {

	public URLCC(CPAbstractImpl impl) {
		super(impl, URL.class, new URLSerializer());
	}

	public static class URLSerializer extends SimpleSerializer<URL> {

		@Override
		public URL parse(String value) throws Exception {
			return new URL(value);
		}

		@Override
		public String serialize(URL value) throws Exception {
			return value.toExternalForm();
		}

	}
}
