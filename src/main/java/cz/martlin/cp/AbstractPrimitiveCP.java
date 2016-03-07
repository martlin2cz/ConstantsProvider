package cz.martlin.cp;

/**
 * Set of primitive types constants.
 * 
 * 
 * @author martlin
 *
 */
public interface AbstractPrimitiveCP {
	public abstract byte get(String name, byte dflt);

	public abstract short get(String name, short dflt);

	public abstract int get(String name, int dflt);

	public abstract long get(String name, long dflt);

	public abstract float get(String name, float dflt);

	public abstract double get(String name, double dflt);

	public abstract char get(String name, char dflt);

	public abstract boolean get(String name, boolean dflt);

}
