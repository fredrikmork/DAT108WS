package Sparegris;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
	
	private Pengeforbruk forbruk;
	private ArrayList<Kategori> kategori;
	private DAO dao;
	
	/**
	 * @param dato, beløp og kategori
	 * @return dato, beløp og kategori
	 */
	public void registrerPengeforbruk(LocalDate dato, int beløp, Kategori kategori) {
		Utgift utgift = new Utgift(beløp, dato, kategori);
		forbruk = new Pengeforbruk(utgift);
	}
	/**
	 * 
	 * @return
	 */
	public String vis_dagens_utgifter() {
		return "";
	}
	/**
	 * 		
	 * @return
	 */
	public String vis_månedens_utgifter() {
			return "";
	}
		
	/**
	 * 	
	 * @param navn
	 */
	public void registrer_ny_kategori(String navn) {
		Kategori kategorigwe = new Kategori(navn);
		kategori.add(kategorigwe);
	}
	/**
	 * 
	 * @return
	 */
	public String visUtgift() {	
		return "";
	}
}
