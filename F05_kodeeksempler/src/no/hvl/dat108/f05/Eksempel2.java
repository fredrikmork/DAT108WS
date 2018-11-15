package no.hvl.dat108.f05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Eksempel2 går ut på å lage vårt eget fleksible filter. Filteret tar inn en
 * liste av tall og returnerer en ny liste med de tallene som oppfyller en
 * gitt betingelse.
 * 
 * Betingelse er en såkalt funksjonell kontrakt (interface), dvs. en kontrakt
 * med én enkelt metode. Her en metode som tar en int og returnerer en boolean.
 * 
 * 1
 * Vi ser igjen først på hvordan dette kan gjøres på "gamlemåten" ved å lage
 * en klasse PartallBetingelse som implementerer Betingelse-kontrakten, og
 * gi et objekt av denne inn til filteret.
 * 
 * 2
 * Vi ser hvordan dette kan forenkles betraktlig ved å bruke et lambda-uttrykk.
 * 
 * 3
 * Vi ser hvordan vi kan lage et "dynamisk" lambda-uttrykk som en retur fra
 * en metode. Dette gir oss enda større fleksibilitet og lesbarhet.
 * 
 * 
 */
public class Eksempel2 {
	
	public static void main(String[] args) {

		List<Integer> listen = Arrays.asList(-4, 9, 2, 7, 6, 0);
		List<Integer> filtrertListe;
		
		//1
		filtrertListe = filter(listen, new PartallBetingelse());
		System.out.println(filtrertListe);
		
		//2
		filtrertListe = filter(listen, x -> x > 0);
		System.out.println(filtrertListe);
		
		//3
		filtrertListe = filter(listen, storreEnn(7));
		System.out.println(filtrertListe);
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

	public static Betingelse storreEnn(int grense) {
		return x -> x > grense;
	}
}

@FunctionalInterface
interface Betingelse {
	boolean erSant(int tall);
}

class PartallBetingelse implements Betingelse {

	@Override
	public boolean erSant(int tall) {
		return tall % 2 == 0;
	}
}


