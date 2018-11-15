package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		List<Utvikler> utviklere = Arrays.asList(
				new Utvikler("Arne", Arrays.asList("Java", "C")),
				new Utvikler("Fredda", Arrays.asList("C++", "Python")),
				new Utvikler("Simen", Arrays.asList("C#", "C", "C++")),
				new Utvikler("Kristforre", Arrays.asList("PHP", "JavaScript"))
				);
		
		//Utviklere som kan Java:
		utviklere.stream()
				.filter(u -> u.getSpraak().contains("Java"))
				.forEach(System.out::println);
		
		//Navn på en utvikler som kan C#, evt "INGEN" om ingen
		String cSharp =utviklere.stream()
				.filter(u -> u.getSpraak().contains("C#"))
				.map(u -> u.getNavn())
				.findAny().orElse("INGEN");
		System.out.println(cSharp);
		//Sortert liste over alle språkene utviklerne kan
		utviklere.stream()
				.map(u -> u.getSpraak())
				.flatMap(x -> x.stream())
				.distinct()
				.sorted()
				.forEach(System.out::println);
		
		//Hvilket språk flest utviklere kan.
		utviklere.stream()
				.flatMap(u -> u.getSpraak().stream())
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream()
				.max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
				.ifPresent(e -> System.out.println(e.getKey()));
	}
}
