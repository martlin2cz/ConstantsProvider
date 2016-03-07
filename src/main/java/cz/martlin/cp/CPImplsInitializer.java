package cz.martlin.cp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.martlin.cp.impls.CPDefaultsImpl;
import cz.martlin.cp.impls.CPExportMissingsImpl;
import cz.martlin.cp.impls.CPFromFileImpl;

/**
 * Tool for creating {@link CPAbstractImpl} depending on current environment
 * config. The environment config is given by {@link #PROPERTY_NAME}'s value.
 * Depending on its value method {@link #getImpl()} returns corresponding
 * implementation of CP.
 * 
 * @see CPAbstractImpl
 * 
 * @author martin
 *
 */
public class CPImplsInitializer {
	private final Logger log = LoggerFactory.getLogger(getClass());

	public static final String PROPERTY_NAME = CP.class.getName();
	public static final String DEFAULT_FILE = "constants.properties";
	public static final String DEFAULTS = "DISABLE";
	public static final String EXPORT = "EXPORT";

	public static final int DEFAULT_TIMEOUT = 1000;

	/**
	 * Creates impl depending on value of {@link #PROPERTY_NAME}. If is null
	 * (i.e. not set), returns default file impl. If is equal to {@link #EXPORT}
	 * , returns export file impl (with {@link #DEFAULT_TIMEOUT} timeout). If is
	 * equal to {@link #DEFAULTS}, returs defaults impl. Else, if no of theese
	 * values is provided, given value is used as file name to file impl.
	 * 
	 * @return
	 */
	public CPAbstractImpl getImpl() {
		String propVal = System.getProperty(PROPERTY_NAME);
		if (propVal == null) {
			return createFileImpl(DEFAULT_FILE);
		}

		switch (propVal) {
		case DEFAULTS:
			return createDefaultsImpl();
		case EXPORT:
			return createExportImpl();
		default:
			return createFileImpl(propVal);
		}
	}

	/**
	 * Creates instance with providing by defaults values.
	 * 
	 * @return
	 */
	private CPDefaultsImpl createDefaultsImpl() {
		log.info("Created Defaults implementation.");
		return new CPDefaultsImpl();
	}

	/**
	 * Creates instance exporting defaults to file. If fails, returns defaults
	 * impl.
	 * 
	 * @return
	 */
	private CPAbstractImpl createExportImpl() {
		File file;
		OutputStream destination;
		try {
			file = File.createTempFile("constants", ".properties");
			destination = new FileOutputStream(file);
		} catch (IOException e) {
			log.error("Cannot create or write export file. Cause: " + e);
			return createDefaultsImpl();
		}

		int timeout = DEFAULT_TIMEOUT;
		log.info("Created Constants exporting implementation. Will export into [{}] after [{}] ms.",
				file.getAbsolutePath(), timeout);

		return new CPExportMissingsImpl(destination, timeout);
	}

	/**
	 * Creates instance loading constants from given file. If file read fails,
	 * returns defaults impl.
	 * 
	 * @param path
	 * @return
	 */
	private CPAbstractImpl createFileImpl(String path) {
		File file = new File(path);
		InputStream ins;
		try {
			ins = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			log.error("Cannot open file [" + file.getAbsolutePath() + "]. Cause: " + e);
			return createDefaultsImpl();
		}

		log.info("Created File reading implementation. Will read constants from [{}].", file.getAbsolutePath());

		return new CPFromFileImpl(ins);
	}

}
