package cz.martlin.cptesting;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cz.martlin.cp.impls.CPFromFileImpl;
import cz.martlin.cp.impls.ConstantsIO;
import cz.martlin.cp.impls.ConstantsList;

/**
 * Creates testing data in various formats.
 * 
 * @author martin
 *
 */
public class TestCreator {

	public static ConstantsList createList(Class<?> destination) {
		InputStream source = createPropertiesFileStream(destination);
		ConstantsIO io = new ConstantsIO(source, null);
		return new ConstantsList(io);
	}

	public static CPFromFileImpl createFileImpl(Class<?> destination) {
		InputStream source = createPropertiesFileStream(destination);
		return new CPFromFileImpl(source);
	}

	private static InputStream createPropertiesFileStream(Class<?> destination) {
		String clazz = destination.getName();
		Properties props = new Properties();

		addToProps(clazz, props);

		ByteArrayOutputStream ous = new ByteArrayOutputStream();
		try {
			props.store(ous, "something...");
		} catch (IOException e) {
			fail(e.getMessage());
		}

		InputStream source = new ByteArrayInputStream(ous.toByteArray());
		return source;
	}

	private static void addToProps(String clazz, Properties props) {
		props.put(clazz + ".port", "42");
		props.put(clazz + ".host", "localhost");
		// TODO ...
	}

}
