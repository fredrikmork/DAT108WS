package Sparegris;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DAO {
	private Pengeforbruk pengeforbruk;
	private ArrayList<Utgift> utgifter;
	
	public DAO (Pengeforbruk pengeforbruk) {
		this.pengeforbruk = pengeforbruk;
	}
	/**
	 *  Lagrer gitt utgift til en liste med Utgifter
	 * @param utgift
	 */
	public void lagreNyUtgift (Utgift utgift) {
		utgifter.add(utgift);
	}
	
	/**
	 *  finner utgifter for i dag.
	 * @param dagens dato 
	 */
	public ArrayList<Utgift> finnUtgifterD (LocalDate idag) {
		ArrayList<Utgift> dagensU = new ArrayList<Utgift>();
		for (Utgift u : utgifter) {
			if (u.getDato().equals(idag)) {
				dagensU.add(u);
			}
			
		}
		return dagensU;
	}
	/**
	 * finner utgifter for denne måneden.
	 * @param denne måned
	 */
	public ArrayList<Utgift> finnUtgifterM (int maaned) {
		ArrayList<Utgift> maanedU = new ArrayList<Utgift>();
		for (Utgift u : utgifter) {
			if (u.getDato().getMonthValue() == (maaned)) {
				maanedU.add(u);
			}
		}
		return maanedU;
	}
	/**
	 * lagrer den nye kategorien
	 * @param kategori
	 */
	public void lagreNyKategori (Kategori kategori) {
		
	}
	//Getters and setters
	public Pengeforbruk getPengeforbruk() {
		return pengeforbruk;
	}

	public void setPengeforbruk(Pengeforbruk pengeforbruk) {
		this.pengeforbruk = pengeforbruk;
	}
}
