package cz.martlin.cp.ccs;

import java.text.DateFormat;
import java.util.Date;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.ConstantCreator;
import cz.martlin.cp.serializer.SimpleSerializer;

public class DateCC extends ConstantCreator<Date> {

	public static final DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);

	public DateCC(CPAbstractImpl impl) {
		super(impl, Date.class, new DateSerializer());
	}

	public static class DateSerializer extends SimpleSerializer<Date> {

		@Override
		public Date parse(String value) throws Exception {
			return format.parse(value);
		}

		@Override
		public String serialize(Date value) throws Exception {
			return format.format(value);
		}

	}
}
