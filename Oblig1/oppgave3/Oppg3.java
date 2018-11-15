package oppgave3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg3 {

	/**
	 * 
	 * @param prosentøkning
	 *            "i" i form av 1.00
	 * @return endret lønn
	 */
	public static Function<Integer, Integer> prosentTillegg(double i) {
		return x -> (int) (x * i);
	}

	/**
	 * 
	 * @return ny lønn med 50 i økning
	 */
	public static Function<Integer, Integer> fastTillegg() {
		return x -> (x + 50);
	}

	// Main
	public static void main(String[] args) {
		/**
		 * Hvis en tjener under 50 så skal lønnen økes med 20
		 */
		Function<Integer, Integer> lavLonn = lonn -> {
			if (lonn < 50) {
				return lonn + 20;
			}
			return lonn;
		};

		List<Ansatt> people = Arrays.asList(new Ansatt("Fredda", "G", 'M', "Sjef", 60),
				new Ansatt("Herborg", "Sjo", 'K', "Nestleder", 42), new Ansatt("Kristoffer", "Pe", 'M', "Lasser", 51),
				new Ansatt("Simen", "Gjerde", 'M', "Losser", 45));
		
		System.out.println(people);

		// Øk lønn med 10 prosent
		people.get(0).endreLonn(prosentTillegg(10));
		;

		// Hvis lav lønn øk den
		people.stream().forEach(a -> a.endreLonn(lavLonn));
		
		//Fast lønnsøkning
		people.get(1).endreLonn(fastTillegg());
		
		System.out.println(people);
	}

}
