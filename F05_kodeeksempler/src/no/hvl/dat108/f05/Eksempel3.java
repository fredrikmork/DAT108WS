package no.hvl.dat108.f05;

/*
 * En liten oppgave dere skulle prøve selv for å se om dere hadde
 * fått med dere hovedidéen med lambda-uttrykk.
 * 
 * Oppgaveteksten:
 * 
 * Lag en generell metode betingetUtskrift(...) som tar inn en streng 
 * og et (false | true) lambda-uttrykk og som skriver ut strengen kun 
 * hvis uttrykket er sant.
 * 
 * Lag en main(...)-metode som tester dette ut med et par ulike input, 
 * f.eks. krav om at stringen begynner på "X" eller at den er lengre 
 * enn 3 tegn.
 */
public class Eksempel3 {

	private static void betingetUtskrift(String s, StringBetingelse b) {
		if (b.erSann(s)) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		betingetUtskrift("Xi", s -> s.startsWith("X"));
		betingetUtskrift("Knut", s -> s.startsWith("X"));
		betingetUtskrift("Per", s -> s.length() > 3);
		betingetUtskrift("Anne", s -> s.length() > 3);
	}

}

interface StringBetingelse {
	boolean erSann(String s);
}

