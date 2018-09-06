package Sparegris;

import java.time.LocalDate;

public class Pengeforbruk {
	private Utgift utgift; 
	private DAO dao;
	
	public Pengeforbruk (Utgift utgift) {
		this.utgift = utgift;
	}
	/**
	 * 
	 * @param dato
	 * @param beløp
	 * @param kategori
	 */
	public void registrerUtgift(int beløp, LocalDate dato, Kategori kategori) {
		Utgift utgift = new Utgift(beløp, dato, kategori);
		
		
	}
	
	public void finnDagensUtgifter () {
		
	}

	public void finnMånedensUtgifter () {
		
	}
	
	public Utgift getUtgift() {
		return utgift;
	}

	public void setUtgift(Utgift utgift) {
		this.utgift = utgift;
	}
	
}
