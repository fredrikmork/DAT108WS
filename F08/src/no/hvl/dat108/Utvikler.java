package no.hvl.dat108;

import java.util.List;

public class Utvikler {
	private String navn;
	private List<String> spraak;

	public Utvikler(String navn, List<String> spraak) {
		this.navn = navn;
		this.spraak = spraak;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public List<String> getSpraak() {
		return spraak;
	}

	public void setSpraak(List<String> spraak) {
		this.spraak = spraak;
	}

	@Override
	public String toString() {
		return "Utvikler [navn=" + navn + ", spraak=" + spraak + "]";
	}
	

}
