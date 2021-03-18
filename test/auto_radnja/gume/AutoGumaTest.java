package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	AutoGuma ag;
	@BeforeEach
	void setUp() throws Exception {
		ag=new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag=null;
	}

	@Test
	void testAutoGuma() {
		ag=new AutoGuma();
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag=new AutoGuma("MarkaModel",14,136,26);
		assertNotNull(ag);
		assertEquals("MarkaModel",ag.getMarkaModel());
		assertEquals(26,ag.getVisina());
		assertEquals(14,ag.getPrecnik());
		assertEquals(136,ag.getSirina());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("MarkaModel");
		assertEquals("MarkaModel",ag.getMarkaModel());
	}
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, 
				()-> ag.setMarkaModel(null));
	}
	@Test
	void testSetMarkaModelKratakString() {
		assertThrows(java.lang.RuntimeException.class, 
				()-> ag.setMarkaModel("12"));
	}

	@ParameterizedTest
	@CsvSource({
		"14"
	})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		assertEquals(precnik,ag.getPrecnik());
	}
	@Test
	void testSetPrecnikVanOpsegaManji() {
		assertThrows(java.lang.RuntimeException.class,()->ag.setPrecnik(12));
	}
	@Test
	void testSetPrecnikVanOpsegaVeci() {
		assertThrows(java.lang.RuntimeException.class,()->ag.setPrecnik(23));
	}


	@ParameterizedTest
	@CsvSource({
		"136"
	})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		assertEquals(sirina,ag.getSirina());
	}
	@Test
	void testSetSirinaVanOpsegaManji() {
		assertThrows(java.lang.RuntimeException.class,()->ag.setSirina(134));
	}
	@Test
	void testSetSirinaVanOpsega() {
		assertThrows(java.lang.RuntimeException.class,()->ag.setSirina(356));
	}

	@ParameterizedTest
	@CsvSource({
		"26"
	})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		assertEquals(visina,ag.getVisina());
	}
	@Test
	void testSetVisinaVanOpsegaManji() {
		assertThrows(java.lang.RuntimeException.class,()->ag.setVisina(24));
	}
	@Test
	void testSetVisinaVanOpsegaVeci() {
		assertThrows(java.lang.RuntimeException.class,()->ag.setVisina(96));
	}
		
	@Test
	void testToString() {
		ag.setMarkaModel("MarkaModel");
		ag.setPrecnik(14);
		ag.setVisina(26);
		ag.setSirina(136);
		String s=ag.toString();
		assertTrue(s.contains("MarkaModel"));
		assertTrue(s.contains("14"));
		assertTrue(s.contains("26"));
		assertTrue(s.contains("136"));
	}
	@ParameterizedTest
	@CsvSource({
		"MarkaModel, 14, 136, 26, MarkaModel, 14, 136, 26, true",
		"MarkaModel, 14, 136, 26, MarkaModel2, 14, 136, 26, false",
		"MarkaModel, 14, 136, 26, MarkaModel, 15, 136, 26, false",
		"MarkaModel, 14, 136, 26, MarkaModel, 14, 137, 26, false",
		"MarkaModel, 14, 136, 26, MarkaModel, 14, 136, 27, false",
		
		"MarkaModel, 14, 136, 26, MarkaModel2, 15, 136, 26, false",
		"MarkaModel, 14, 136, 26, MarkaModel2, 15, 137, 26, false",
		"MarkaModel, 14, 136, 26, MarkaModel2, 15, 137, 27, false",
		"MarkaModel, 14, 136, 26, MarkaModel2, 14, 136, 27, false",
		"MarkaModel, 14, 136, 26, MarkaModel2, 14, 137, 26, false",
		
		"MarkaModel, 14, 136, 26, MarkaModel, 15, 137, 26, false",
		"MarkaModel, 14, 136, 26, MarkaModel, 15, 137, 27, false",
		"MarkaModel, 14, 136, 26, MarkaModel, 15, 136, 27, false",	
		
		"MarkaModel, 14, 136, 26, MarkaModel, 14, 137, 27, false"
	})
	void testEqualsObjectString (String markaModel1, int precnik1, int sirina1, int visina1,String markaModel2, int precnik2, int sirina2, int visina2, boolean eq) {
		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		AutoGuma ag2=new AutoGuma();
		ag2.setMarkaModel(markaModel2);
		ag2.setPrecnik(precnik2);
		ag2.setSirina(sirina2);
		ag2.setVisina(visina2);
		assertEquals(eq, ag.equals(ag2));
	}

}
