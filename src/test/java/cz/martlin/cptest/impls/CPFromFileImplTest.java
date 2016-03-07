package cz.martlin.cptest.impls;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.martlin.cp.CPAbstractImpl;
import cz.martlin.cp.impls.CPFromFileImpl;
import cz.martlin.cptesting.TestCreator;

public class CPFromFileImplTest {

	@Test
	public void testGetCallee() {
		assertEquals(CPFromFileImplTest.class, CPAbstractImpl.getCallee());

	}

	@Test
	public void testGet() {
		CPFromFileImpl impl = TestCreator.createFileImpl(CPFromFileImplTest.class);

		assertEquals(42, impl.get("port", 80));
		assertEquals(80, impl.get("portal", 80));

	}

}
