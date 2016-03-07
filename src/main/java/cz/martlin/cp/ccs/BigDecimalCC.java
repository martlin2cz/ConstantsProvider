package cz.martlin.cp.ccs;

import java.math.BigDecimal;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.ConstantCreator;
import cz.martlin.cp.serializer.SimpleSerializer;

public class BigDecimalCC extends ConstantCreator<BigDecimal> {

	public BigDecimalCC(CPAbstractImpl impl) {
		super(impl, BigDecimal.class, new BigDecimalSerializer());
	}

	public static class BigDecimalSerializer extends SimpleSerializer<BigDecimal> {

		@Override
		public BigDecimal parse(String value) throws Exception {
			return new BigDecimal(value);
		}

		@Override
		public String serialize(BigDecimal value) throws Exception {
			return value.toPlainString();
		}

	}

}
