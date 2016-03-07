package cz.martlin.cp.ccs;

import java.io.File;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.ConstantCreator;
import cz.martlin.cp.serializer.SimpleSerializer;

public class FileCC extends ConstantCreator<File> {

	public FileCC(CPAbstractImpl impl) {
		super(impl, File.class, new FileSerializer());
	}

	public static class FileSerializer extends SimpleSerializer<File> {

		@Override
		public File parse(String value) throws Exception {
			return new File(value);
		}

		@Override
		public String serialize(File value) throws Exception {
			return value.getPath();
		}

	}

}
