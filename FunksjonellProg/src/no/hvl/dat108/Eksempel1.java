package no.hvl.dat108;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class AlfabetiskSammenligner implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.toUpperCase().compareTo(o2.toUpperCase());
	}
	
}
public class Eksempel1 {
	
	public static void main(String[] args) {
		List<String> listen = Arrays.asList("Halo", "blabla", "Fyfaen", "Kjørda");
		//#1
		Collections.sort(listen, new AlfabetiskSammenligner());
		System.out.println(listen);
		//#2 
		Collections.sort(listen, new Comparator<String>() {
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
		});
		System.out.println(listen);
		//#3 sorterer på lengde
		Collections.sort(listen, (a,b) -> a.length() - b.length());
		System.out.println(listen);
	}
	
}
