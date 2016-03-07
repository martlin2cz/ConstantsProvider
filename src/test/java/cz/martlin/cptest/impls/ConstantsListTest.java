package cz.martlin.cptest.impls;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.martlin.cp.impls.ConstantsList;
import cz.martlin.cptesting.SomeServerConfig;
import cz.martlin.cptesting.TestCreator;

public class ConstantsListTest {

	// @Before
	// public void setUp() {
	// }

	private static final String PORT_CNAME = SomeServerConfig.class.getName() + ".port";

	@Test
	public void testGet() {
		ConstantsList list = TestCreator.createList(SomeServerConfig.class);
		assertEquals(42, (int) list.get("port", SomeServerConfig.class, int.class).getValue());
	}

	@Test
	public void testGetOrDefault() {
		ConstantsList list = TestCreator.createList(SomeServerConfig.class);
		assertEquals(42, (int) list.getOrDefault("port", SomeServerConfig.class, int.class, 80));
		assertEquals(80, (int) list.getOrDefault("nothing", SomeServerConfig.class, int.class, 80));
	}

	@Test
	public void testConvert() {
		ConstantsList list = TestCreator.createList(SomeServerConfig.class);

		assertEquals(42, (int) list.convert("42", int.class).getValue());
		assertEquals(true, (boolean) list.convert("true", boolean.class).getValue());
		assertEquals(null, list.convert("foo", int.class));
	}

	@Test
	public void testGetValueOf() {
		ConstantsList list = TestCreator.createList(SomeServerConfig.class);

		assertEquals("42", list.getValueOf(PORT_CNAME));
	}

	@Test
	public void testConstructKey() {
		ConstantsList list = TestCreator.createList(SomeServerConfig.class);

		assertEquals(PORT_CNAME, list.constructKey("port", SomeServerConfig.class));
	}

	// @Test
	// public void testLoad() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSave() {
	// fail("Not yet implemented");
	// }

}
