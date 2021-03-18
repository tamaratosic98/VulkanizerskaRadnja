package auto_radnja;
import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;
/**
 * Intefejs koji predstavlja Radnju.
 * 
 * @author Tamara Tosic
 * @version 2.0
 */
public interface Radnja {
	/**
	 * Dodaje novu gumu u radnju.
	 * @param a Auto guma koja se dodaje.
	 * 
	 * @throws java.lang.NullPointerException Ako je uneta guma null.
	 * @throws java.lang.RuntimeException Ako uneta guma vec postoji u radnji (duplikat).
	 */
	void dodajGumu(AutoGuma a);
	/**
	 * Pronalazi gumu u radnji po zadatom parametru markaModel.
	 * @param markaModel Marka i model po kome se pretrazuje radnja.
	 * @return 
	 * <ul>
	 * 		<li> Null ukoliko je prosledjen markaModel null. </li>
	 * 		<li> Lista auto guma koja odgovara kriterijumu pretrage. </li>
	 * </ul>
	 * 
	 */
    LinkedList<AutoGuma> pronadjiGumu(String markaModel);
 
}
