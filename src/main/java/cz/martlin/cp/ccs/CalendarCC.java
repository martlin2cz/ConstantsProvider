package cz.martlin.cp.ccs;

import java.util.Calendar;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.ConstantCreator;
import cz.martlin.cp.serializer.SimpleSerializer;

public class CalendarCC extends ConstantCreator<Calendar> {

	
	public CalendarCC(CPAbstractImpl impl) {
		super(impl, Calendar.class, new CalendarSerializer());
	}

	public static class CalendarSerializer extends SimpleSerializer<Calendar> {

		@Override
		public Calendar parse(String value) throws Exception {
			throw new UnsupportedOperationException("Calendars ...");
		}

		@Override
		public String serialize(Calendar value) throws Exception {
			throw new UnsupportedOperationException("Calendars ...");
		}

	}

}
