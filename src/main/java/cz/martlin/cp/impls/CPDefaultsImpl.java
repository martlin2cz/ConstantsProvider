package cz.martlin.cp.impls;

import cz.martlin.cp.CPAbstractImpl;

/**
 * Implementation of {@link CPAbstractImpl} such that names of constants are
 * ignored and are directly returned defaults values.
 * 
 * @author martin
 *
 */
public class CPDefaultsImpl extends CPAbstractImpl {

	public CPDefaultsImpl() {
	}

	@Override
	public byte get(String name, byte dflt) {
		return dflt;
	}

	@Override
	public short get(String name, short dflt) {
		return dflt;
	}

	@Override
	public int get(String name, int dflt) {
		return dflt;
	}

	@Override
	public long get(String name, long dflt) {
		return dflt;
	}

	@Override
	public float get(String name, float dflt) {
		return dflt;
	}

	@Override
	public double get(String name, double dflt) {
		return dflt;
	}

	@Override
	public char get(String name, char dflt) {
		return dflt;
	}

	@Override
	public boolean get(String name, boolean dflt) {
		return dflt;
	}

	@Override
	public <T> T get(String name, Class<T> type, T dflt) {
		return dflt;
	}

}
