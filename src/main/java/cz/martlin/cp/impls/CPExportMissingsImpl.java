package cz.martlin.cp.impls;

import java.io.OutputStream;

import cz.martlin.cp.CPAbstractImpl;

/**
 * Represents exporting {@link CPAbstractImpl}. Each attempt to get constant
 * stores its given default value and after given timeout are collected defaults
 * values stored into provede output as properties file.
 * 
 * @author martin
 *
 */
public class CPExportMissingsImpl extends CPAbstractImpl {

	private final ConstantsList list;

	public CPExportMissingsImpl(OutputStream destination, int timeout) {
		ConstantsIO io = new ConstantsIO(null, destination);
		this.list = new ConstantsList(io);
		sheduleThread(timeout);
	}

	private void sheduleThread(int timeout) {
		Thread thread = new ExportThread(list, timeout);
		thread.start();
	}

	@Override
	public byte get(String name, byte dflt) {
		return list.setDefault(name, getCallee(), byte.class, dflt);
	}

	@Override
	public short get(String name, short dflt) {
		return list.setDefault(name, getCallee(), short.class, dflt);
	}

	@Override
	public int get(String name, int dflt) {
		return list.setDefault(name, getCallee(), int.class, dflt);
	}

	@Override
	public long get(String name, long dflt) {
		return list.setDefault(name, getCallee(), long.class, dflt);
	}

	@Override
	public float get(String name, float dflt) {
		return list.setDefault(name, getCallee(), float.class, dflt);
	}

	@Override
	public double get(String name, double dflt) {
		return list.setDefault(name, getCallee(), double.class, dflt);
	}

	@Override
	public char get(String name, char dflt) {
		return list.setDefault(name, getCallee(), char.class, dflt);
	}

	@Override
	public boolean get(String name, boolean dflt) {
		return list.setDefault(name, getCallee(), boolean.class, dflt);
	}

	@Override
	public <T> T get(String name, Class<T> type, T dflt) {
		return list.setDefault(name, getCallee(), type, dflt);
	}

}
