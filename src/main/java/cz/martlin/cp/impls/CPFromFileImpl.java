package cz.martlin.cp.impls;

import java.io.InputStream;

import cz.martlin.cp.CPAbstractImpl;

/**
 * Implementation of {@link CPAbstractImpl} such that constants are found in
 * properties file in input stream.
 * 
 * @author martin
 *
 */
public class CPFromFileImpl extends CPAbstractImpl {

	private final ConstantsList list;

	public CPFromFileImpl(InputStream source) {
		ConstantsIO io = new ConstantsIO(source, null);
		this.list = new ConstantsList(io);
	}

	@Override
	public byte get(String name, byte dflt) {
		return list.getOrDefault(name, getCallee(), byte.class, dflt);
	}

	@Override
	public short get(String name, short dflt) {
		return list.getOrDefault(name, getCallee(), short.class, dflt);
	}

	@Override
	public int get(String name, int dflt) {
		return list.getOrDefault(name, getCallee(), int.class, dflt);
	}

	@Override
	public long get(String name, long dflt) {
		return list.getOrDefault(name, getCallee(), long.class, dflt);
	}

	@Override
	public float get(String name, float dflt) {
		return list.getOrDefault(name, getCallee(), float.class, dflt);
	}

	@Override
	public double get(String name, double dflt) {
		return list.getOrDefault(name, getCallee(), double.class, dflt);
	}

	@Override
	public char get(String name, char dflt) {
		return list.getOrDefault(name, getCallee(), char.class, dflt);
	}

	@Override
	public boolean get(String name, boolean dflt) {
		return list.getOrDefault(name, getCallee(), boolean.class, dflt);
	}

	@Override
	public <T> T get(String name, Class<T> type, T dflt) {
		return list.getOrDefault(name, getCallee(), type, dflt);
	}

}
