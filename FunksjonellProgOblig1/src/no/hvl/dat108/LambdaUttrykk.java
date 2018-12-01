package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaUttrykk {
	/**
	 * 
	 * @param i
	 *            som er 100% av 1.00
	 * @return ny lønn som i følge av prosenttillegget
	 */
	public static Function<Integer, Integer> prosentLonn(double i) {
		return lonn -> (int) (lonn * i);
	}
	/**
	 * 
	 * @param tillegg 
	 * @return ny lønn som kommer av forrige lønn pluss tillegg
	 */
	public static Function<Integer, Integer> fastTillegg(int tillegg) {
		return lonn -> lonn + tillegg;
	}


	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(new Ansatt("Fredrik", "Mørk", 'M', "Sjef", 750000),
				new Ansatt("Kåre", "Arndt", 'M', "Nest-sjef", 650000),
				new Ansatt("Anne", "Mørk", 'K', "Sekretær", 750000),
				new Ansatt("Frida", "Hansen", 'K', "Advokat", 600000),
				new Ansatt("Arne", "Kar", 'M', "Økonom", 550000));
		/**
		 * tilleggslønn på 50 000 hvis noen ahr lavere lønn enn 600 000.
		 */
		Function<Integer, Integer> nyLonn = lonn -> {
			if(lonn<600000) {
				return lonn + 50000;
			}
			return lonn;
		};
		
		/**
		 * Hvis noen har lønn under 600 000 får de 50 000 i tilleggslønn
		 */
		for(Ansatt a: ansatte) {
			a.endreLonn(nyLonn);;
			System.out.println(a.getAarslonn());
		}
		System.out.println();
		//eller slik. bruker stream for å gå gjennom alle i ansatte, for hver sjekker den om den har lav lønn, hvis så øker den.
		ansatte.stream().forEach(a -> a.endreLonn(nyLonn));
		
		//hvis årslønnen er på 750 000kr øk den med 50 000
		ansatte.stream().filter(a -> a.getAarslonn() == 750000).
				forEach(a -> a.endreLonn(fastTillegg(50000)));
		
		/**
		 * Oppgave 4 - Streams
		 * a) Lag en ny liste som kun innholder etternavnene til de ansatte:
		 */
		System.out.println("Etternavnliste: ");
		List<String> etternavnListe = 
				ansatte.stream() //Går gjennom alle ansatte
				.map(a -> a.getEtternavn()) //returnerer en stream med alle ansatte gjort om til bare etternavn
				.collect(Collectors.toList()); //gjør om streamen til en streng-liste
		etternavnListe.forEach(System.out::println);
		System.out.println();
		/**
		 * b) Finn ut antall kvinner blant de ansatte
		 */
		System.out.print("Antall kvinnelige ansatte: ");
		int kvinneligeAnsatte = (int)ansatte.stream()
				.filter(a -> a.getKjonn() == 'K') //Filtrerer bort alle som ikke har kjønn K
				.count(); //Teller de som long, men i starten gjøres om til int.
		System.out.println(kvinneligeAnsatte);
		/**
		 * c) Regn ut gjennomsnittslønnen til kvinnene
		 */
		int totalKvinneligLonn = (int)ansatte.stream()
				.filter(a -> a.getKjonn() == 'K')
				.mapToInt(a -> a.getAarslonn())
				.sum();
		int gjennomsnitt = totalKvinneligLonn/kvinneligeAnsatte;
		System.out.println(gjennomsnitt);
		/**
		 * d) Gi alle stillinger = "Sjef" en lønnsøkning på 7%
		 */
		ansatte.stream()
				.filter(a -> a.getStilling() == "Sjef")
				.forEach(a -> a.endreLonn(prosentLonn(1.07)));
		System.out.println(ansatte.get(0).getAarslonn());
		/**
		 * e) Finn ut (true | false) om det er noen ansatte som tjener mer enn 800 000,-
		 */
		boolean merenn = ansatte.stream().map(a -> a.getAarslonn() > 800000).findAny().get();
		boolean eller = ansatte.stream().anyMatch(a -> a.getAarslonn() > 900000); 
		System.out.println(merenn);
		System.out.println(eller);
		
		/**
		 * f) Skriv ut alle ansatte med System.out.println() uten å bruke løkke
		 */
		ansatte.forEach(System.out::print);
		System.out.println();
		/**
		 * g) Finn og skriv ut den/de ansatte som har lavest lønn:
		 */
		System.out.println("Minst lønn: ");
		OptionalInt minst = ansatte.stream()
				.mapToInt(a -> a.getAarslonn()) //stream med åslønn
				.min(); //finner den med minst i streamen
		ansatte.stream()
				.filter(a -> a.getAarslonn() == minst.getAsInt()) //filtrer ut de som ikke har minstelønnen
				.forEach(System.out::print); //Printer de ut
		/**
		 * h) Finn og skriv ut summen av alle heltall i[1, 1000 > som er delelig med 3 eller 5.
		 */
		IntStream.rangeClosed(1,1000)
				.filter(x -> (x % 3 == 0) || (x % 5 == 0))
				.forEach(x -> System.out.print(x + " "));;
		
	}

}
