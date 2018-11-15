package no.hvl.dat108.f05;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Eksempel1 går ut på sortering ved hjelp av Collections.sort()
 * 
 * 		1 - Standard ved hjelp av String sin implementasjon av compareTo()
 * 		2 - Bruk av Comparator<String>, først som vanlig klasse og objekt av denne,
 * 		3 - deretter ved hjelp av anonym indre klasse.
 * 		Nå Java 8:
 * 		4 - En kraftig forenkling av kode ved å bruke et lambda-uttrykk
 * 		5 - Til slutt ser vi at lambda-uttrykket også kan tilordnes en variabel for
 * 			økt lesbarhet og mulig gjenbruk.
 * 
 */
public class Eksempel1 {

	public static void main(String[] args) {
		
		List<String> listen = Arrays.asList(
				"Hallo", "blabla", "knut", "Per");
	
		//1
		Collections.sort(listen); // Her brukes String.compareTo()
		System.out.println(listen);
		
		//2
		Collections.sort(listen, new AlfabetiskComparator());
		System.out.println(listen);
		
		//3
		Collections.sort(listen, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
		});
		System.out.println(listen);
		
		//4
		Collections.sort(listen, (a, b) -> a.length() - b.length());
		System.out.println(listen);

		//5
		Comparator<String> baklengsPaaLengde = (a, b) -> b.length() - a.length();
		Collections.sort(listen, baklengsPaaLengde);
		System.out.println(listen);
	}
}

class AlfabetiskComparator implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		return a.toUpperCase().compareTo(b.toUpperCase());
	}
	
}




