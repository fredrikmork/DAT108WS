package no.hvl.dat108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


interface Betingelse {
	boolean erSant (int tall);
}

class PartallBetingelse implements Betingelse {

	@Override
	public boolean erSant(int tall) {
		return tall % 2 == 0;
	}
	
}

public class Eksempel2 {
	
	public static Betingelse storreEnn (int grense) {
		return x -> x > grense;
	}
	public static void main(String[] args) {
		List<Integer> listen = Arrays.asList(-4, 9, 2, 7,6, 0);
		
		List<Integer> filtrertListe = filter(listen, new PartallBetingelse());
		System.out.println(filtrertListe);
		
		List<Integer> filtrertListe2 = filter(listen, storreEnn(3));
		System.out.println(filtrertListe2);
	}
	
	public static List<Integer> filter(List<Integer> liste, Betingelse betingelse) {
		List<Integer> resultat = new ArrayList<>();
		for (int e : liste) {
			if (betingelse.erSant(e)) {
				resultat.add(e);
			}
		}
		return resultat;
	}
}
