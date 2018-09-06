package Sparegris;

import java.time.LocalDate;


public class Utgift {
	private int beløp;
	private LocalDate dato;
	private Kategori kategori;
	
	public Utgift(int beløp, LocalDate dato, Kategori kategori) {
		this.beløp = beløp;
		this.dato = dato;
		this.kategori = kategori;
	}
	
	public int getBeløp() {
		return beløp;
	}
	public void setBeløp(int beløp) {
		this.beløp = beløp;
	}
	public LocalDate getDato() {
		return dato;
	}
	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

}
