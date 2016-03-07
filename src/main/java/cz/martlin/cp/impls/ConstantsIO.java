package cz.martlin.cp.impls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Implements input and output of constants, {@link ConstantsList}. Depending on
 * usage of instance must be {@link #input} or {@link #output} (or both of them)
 * provided.
 * 
 * @author martin
 *
 */
public class ConstantsIO {
	private static final String COMMENT = "ConstantsProvider constants file";

	private final InputStream input;
	private final OutputStream output;

	public ConstantsIO(InputStream input, OutputStream output) {
		super();
		this.input = input;
		this.output = output;
	}

	/**
	 * Loads constants from {@link #input}.
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, String> load() throws IOException {
		if (input == null) {
			throw new IOException("Input stream not specified");
		}

		Map<String, String> result = new HashMap<>();
		Properties props = new Properties();

		props.load(input);

		for (Entry<Object, Object> entry : props.entrySet()) {
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();

			result.put(key, value);
		}

		return result;
	}

	/**
	 * Saves constants into {@link #output}.
	 * 
	 * @param constants
	 * @throws IOException
	 */
	public void save(Map<String, String> constants) throws IOException {
		if (output == null) {
			throw new IOException("Output stream not specified");
		}

		Properties props = new Properties();

		for (Entry<String, String> entry : constants.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			props.put(key, value);
		}

		props.store(output, COMMENT);

	}
}
