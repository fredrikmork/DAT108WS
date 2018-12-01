package no.hvl.dat108;

import java.util.function.Function;

public class Ansatt {
	private String fornavn;
	private String etternavn;
	private char kjonn;
	private String stilling;
	private int aarslonn;
	
	public Ansatt(String fornavn, String etternavn, char kjonn, String stilling, int aarslonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.stilling = stilling;
		this.aarslonn = aarslonn;
	}
	/**
	 * 
	 * @param nylønn til gamle ansatt ved å sette forrige lønn så ny lønn.
	 * 
	 */
	public void endreLonn(Function <Integer, Integer> nyLonn) {
		this.aarslonn = nyLonn.apply(getAarslonn());
	}
	
	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public char getKjonn() {
		return kjonn;
	}

	public void setKjonn(char kjonn) {
		this.kjonn = kjonn;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getAarslonn() {
		return aarslonn;
	}

	public void setAarslonn(int aarslonn) {
		this.aarslonn = aarslonn;
	}

	@Override
	public String toString() {
		return "Ansatt [" + fornavn + ", " + etternavn + ", " + kjonn + ", " + stilling
				+ ", " + aarslonn + "]\n";
	}
	
}
