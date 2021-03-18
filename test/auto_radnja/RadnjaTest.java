package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;


public abstract class RadnjaTest {
	public Radnja radnja;
	@Test
	void testDodajGumu() {
		AutoGuma ag=new AutoGuma();
		ag.setMarkaModel("MarkaModel");
		ag.setPrecnik(14);
		ag.setVisina(26);
		ag.setSirina(136);
		radnja.dodajGumu(ag);
		assertEquals(1,radnja.pronadjiGumu(ag.getMarkaModel()).size());
		assertTrue(radnja.pronadjiGumu(ag.getMarkaModel()).contains(ag));
	}
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, 
				()-> radnja.dodajGumu(null));
	}
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma ag=new AutoGuma();
		ag.setMarkaModel("MarkaModel");
		ag.setPrecnik(14);
		ag.setVisina(26);
		ag.setSirina(136);
		radnja.dodajGumu(ag);
		AutoGuma ag2=new AutoGuma();
		ag2.setMarkaModel("MarkaModel");
		ag2.setPrecnik(14);
		ag2.setVisina(26);
		ag2.setSirina(136);
		assertThrows(java.lang.RuntimeException.class, 
				()-> radnja.dodajGumu(ag2));
		
	}

	@Test
	void testPronadjiGumu() {
		AutoGuma ag=new AutoGuma();
		ag.setMarkaModel("MarkaModel");
		ag.setPrecnik(14);
		ag.setVisina(26);
		ag.setSirina(136);
		AutoGuma ag2=new AutoGuma();
		ag2.setMarkaModel("1234");
		ag2.setPrecnik(15);
		ag2.setVisina(27);
		ag2.setSirina(137);
		AutoGuma ag3=new AutoGuma();
		ag3.setMarkaModel("12345");
		ag3.setPrecnik(16);
		ag3.setVisina(28);
		ag3.setSirina(138);

		radnja.dodajGumu(ag);
		radnja.dodajGumu(ag2);
		radnja.dodajGumu(ag3);
		List<AutoGuma> rezultat=radnja.pronadjiGumu("MarkaModel");
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(ag));
	}
	@Test
	void testPronadjiGumuNePostoji() {
		AutoGuma ag=new AutoGuma();
		ag.setMarkaModel("1111");
		ag.setPrecnik(14);
		ag.setVisina(26);
		ag.setSirina(136);
		AutoGuma ag2=new AutoGuma();
		ag2.setMarkaModel("2222");
		ag2.setPrecnik(15);
		ag2.setVisina(27);
		ag2.setSirina(137);
		AutoGuma ag3=new AutoGuma();
		ag3.setMarkaModel("3333");
		ag3.setPrecnik(16);
		ag3.setVisina(28);
		ag3.setSirina(138);
		radnja.dodajGumu(ag);
		radnja.dodajGumu(ag2);
		radnja.dodajGumu(ag3);
		List<AutoGuma> rezultat=radnja.pronadjiGumu("4444");
		assertEquals(0, rezultat.size());

	}
	@Test
	void testPronadjiGumuNePostojiIstaMarkaModel() {
		AutoGuma ag=new AutoGuma();
		ag.setMarkaModel("1111");
		ag.setPrecnik(14);
		ag.setVisina(26);
		ag.setSirina(136);
		AutoGuma ag2=new AutoGuma();
		ag2.setMarkaModel("1111");
		ag2.setPrecnik(15);
		ag2.setVisina(27);
		ag2.setSirina(137);
		AutoGuma ag3=new AutoGuma();
		ag3.setMarkaModel("3333");
		ag3.setPrecnik(16);
		ag3.setVisina(28);
		ag3.setSirina(138);
		radnja.dodajGumu(ag);
		radnja.dodajGumu(ag2);
		radnja.dodajGumu(ag3);
		List<AutoGuma> rezultat=radnja.pronadjiGumu("1111");
		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(ag));
		assertTrue(rezultat.contains(ag2));

	}
	@Test
	void testPronadjiGumuMarkaNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}

}
