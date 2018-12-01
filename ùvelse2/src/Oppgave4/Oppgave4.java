package Oppgave4;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import oppgave3.Ansatt;
import oppgave3.Oppg3;

public class Oppgave4 {
	
	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt ("Fredda", "G", 'M', "Sjef", 60),
				new Ansatt ("Herborg", "Sjo", 'K', "Nestleder", 42),
				new Ansatt("Kristoffer", "Pe", 'M', "Co-sjef", 51),
				new Ansatt("Simen", "Gjerde",'M', "Progger", 45),
				new Ansatt("Mikkel", "Birkeland", 'K', "Elektriker", 90),
				new Ansatt ("Haakon", "Mørk", 'M', "Progger", 43),
				new Ansatt ("Kari", "Traa", 'K', "Utvikler", 53),
				new Ansatt("Lasse", "Are", 'M', "Kaster", 100),
				new Ansatt("Simen", "Ere",'M', "Laster", 55),
				new Ansatt("Are", "Birkeland", 'K', "Elektriker", 89)
		);
//		a) Lag en ny liste som kun inneholder etternavnene til de ansatte.
		List<String> etternavn = ansatte.stream()
				.map(a -> a.getEtternavn())
				.collect(Collectors.toList());
		etternavn.forEach(System.out::println);
//		b) Finn ut antall kvinner blant de ansatte.
		long antallKvinner = ansatte.stream()
				.filter(a -> a.getKjonn() == 'K')
				.count();
		System.out.println(antallKvinner);
//		c) Regn ut gjennomsnittslønnen til kvinnene.
		int lonn = ansatte.stream()
				.filter(a -> a.getKjonn() == 'K')
				.mapToInt(a -> a.getAarslonn())
				.sum();
		long gjennomsnittslonn = lonn/ antallKvinner;
		System.out.println(gjennomsnittslonn);
				
//		d) Gi alle sjefer (stilling = "sjef") en lønnsøkning på 7% (Bruk løsning fra Oppg3)
		ansatte.stream()
				.filter(a -> a.getStilling() == "Sjef")
				.forEach(a -> a.endreLonn(Oppg3.prosentTillegg(1.07)));
			//TODO	
//		e) Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000,-
		boolean merEnn = ansatte.stream()
				.anyMatch(p -> p.getAarslonn() > 80);
		System.out.println(merEnn);
//		f) Skriv ut alle de ansatte med System.out.println() uten å bruke løkke.
		ansatte.forEach(System.out::println);
//		g) Finn og skriv ut den/de ansatte som har lavest lønn.
		System.out.println("Lavest lønn:");
		OptionalInt w = ansatte.stream()
				.mapToInt(a -> a.getAarslonn())
				.min();
		ansatte.stream().filter(a -> a.getAarslonn() == w.getAsInt()).forEach(System.out::println);;
//		h) Finn og skriv ut summen av alle heltall i [1, 1000> som er delelig med 3 eller 5.
//		IntStream.rangeClosed(1,1000)
//				.filter(a -> a.)
		IntStream.rangeClosed(1, 1000)
				.filter(x -> (x % 3 == 0) || (x % 5 == 0))
				.forEach(x -> System.out.print((x + " ")));
	}
}
