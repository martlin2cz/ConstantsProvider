package cz.martlin.cp.ccs;

import java.awt.Color;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.ConstantCreator;
import cz.martlin.cp.serializer.SimpleSerializer;

public class ColorCC extends ConstantCreator<Color> {

	public ColorCC(CPAbstractImpl impl) {
		super(impl, Color.class, new ColorSerializer());
	}

	public static class ColorSerializer extends SimpleSerializer<Color> {

		@Override
		public Color parse(String value) throws Exception {
			throw new UnsupportedOperationException("Colors ...");
		}

		@Override
		public String serialize(Color value) throws Exception {
			throw new UnsupportedOperationException("Colors ...");
		}

	}

}
