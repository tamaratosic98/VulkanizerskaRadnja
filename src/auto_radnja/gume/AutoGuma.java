package auto_radnja.gume;
/**
 * Klasa koja predstavlja AutoGumu.
 * 
 * Auto guma ima markaModel kao String, i precnik, sirinu i visinu kao int vrednosti.
 * 
 * @author Tamara Tosic
 * @version 1.0
 *
 */
public class AutoGuma {
	/**
	 *  Marka i model gume kao String vrednost.
	 */
	private String markaModel = null; 
	/**
	 * Precnik gume kao int vrednost.
	 */
	private int precnik = -1; 
	/**
	 * Sirina gume kao int vrednost.
	 */
	private int sirina = -1;
	/**
	 * Visina gume kao int vrednost.
	 */
	private int visina = -1;
	/**
	 * Konstruktor koji inicijalizuje objekat AutoGuma i nista vise.
	 */
	public AutoGuma() { }
	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za marku i model, precnik, sirinu i visinu auto gume.
	 * 
	 * @param markaModel Marka i model auto gume kao String vrednost.
	 * @param precnik Precnik auto gume kao int vredost.
	 * @param sirina Sirina auto gume kao int vrednosti.
	 * @param visina Visina auto gume kao int vrednost.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) { super();
	            setMarkaModel(markaModel);
	            setPrecnik(precnik);
	            setSirina(sirina);
	            setVisina(visina);
	}
	/**
	 * Vraca marku i model auto gume. 
	 * 
	 * @return Marka i model auto gume kao String vrednost.
	 */
	public String getMarkaModel() { 
		return markaModel;
	}
	/**
	 * Postavlja atribut marka i model auto gume na novu vrednost.
	 * 
	 * @param markaModel Marka i model kao String vrednost.
	 * @throws java.lang.NullPointerException Ako je uneta vrednost atributa markaModel null.
	 * @throws java.lang.RuntimeException Ako je atribut markaModel duzine manje od 3 karaktera.
	 */
	public void setMarkaModel(String markaModel) { 
		if (markaModel==null)
			throw new NullPointerException("Morate uneti marku i model"); 
		if (markaModel.length()<3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka"); 
		this.markaModel = markaModel;
	}
	/**
	 * Vraca precnik auto gume. 
	 * 
	 * @return Precnik auto gume kao String vrednost.
	 */
	public int getPrecnik() { 
		return precnik;
	}
	/**
	 * Postavlja precnik auto gume na novu vrednost.
	 * 
	 * @param precnik Precnik auto gume kao int vrednost.
	 * @throws java.lang.RuntimeException Ako je precnik manji od 13 i veci od 22.
	 * 
	 */
	public void setPrecnik(int precnik) { 
		if (precnik < 13 || precnik > 22)
			throw new RuntimeException("Precnik van opsega"); 
		this.precnik = precnik;
	}
	/**
	 * Vraca sirinu auto gume.
	 * 
	 * @return Sirina auto gume kao int vrednost.
	 */
	public int getSirina() {
		return sirina; 
	}
	/**
	 * Postavlja sirinu auto gume na novu vrednost.
	 * 
	 * @param sirina Sirina auto gume kao int vrednost.
	 * @throws java.lang.RuntimeException Ako je sirina manja od 135 i veca od 355.
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new RuntimeException("Sirina van opsega"); 
		this.sirina = sirina;
	}
	/**
	 * Vraca visinu auto gume.
	 * 
	 * @return Visina auto gume kao int vrednost.
	 */
	public int getVisina() { 
		return visina;
	}
	/**
	 * Postavlja visinu auto gume na novu vrednost.
	 * 
	 * @param visina Visina auto gume kao int vrednost.
	 * @throws java.lang.RuntimeException Ako je visina manja od 25 i veca od 95.
	 */
	public void setVisina(int visina) { 
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega"); 
		this.visina = visina;
	}
	/**
	 * Vraca String za svim podacima auto gume.
	 */
	@Override
	public String toString() {
	return "AutoGuma [markaModel=" + markaModel +
			", precnik=" + precnik +
			", sirina=" + sirina + ", visina=" + visina + "]";
	}
	/**
	 * Poredi dve auto gume i vraca true ako su iste a false ako nisu. 
	 * 
	 * Auto gume se porede po atributima markaModel, precnik, sirina i visina i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul> 
	 * 	<li> True ako su oba objekta klase AutoGuma ista. </li>
	 * 	<li> False u svim ostalim slucajevima. </li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true; 
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj; 
		if (markaModel == null) {
			if (other.markaModel != null) 
				return false;
		} else if (!markaModel.equals(other.markaModel)) 
			return false;
		if (precnik != other.precnik) 
			return false;
		if (sirina != other.sirina) 
			return false;
		if (visina != other.visina) 
			return false;
	return true;
	}
}
