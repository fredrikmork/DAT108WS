package Oppgave4;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import oppgave3.Ansatt;

public class Streams {
	public static void main(String[] args) {
		List<Ansatt> people = Arrays.asList(
				new Ansatt ("Fredda", "G", 'M', "Sjef", 60),
				new Ansatt ("Herborg", "Sjo", 'K', "Nestleder", 42),
				new Ansatt("Kristoffer", "Pe", 'M', "Lasser", 51),
				new Ansatt("Simen", "Gjerde",'M', "Losser", 45)
		);
		//Example 2
		List<String> lastNames = people.stream()
				.filter(p -> p.getAarslonn() > 50)
				.map(p -> p.getEtternavn())
				.collect(Collectors.toList());
		lastNames.forEach(System.out::println);
		
		//Eksempel1
		people.stream()
				.filter(p -> p.getFornavn().startsWith("H"))
				.forEach(System.out::println);
		for (Ansatt p: people) {
			if (p.getFornavn().startsWith("H")) {
				System.out.println(p);
			}
		}
		//Example 2
		List<String> etternavnene = new ArrayList<>();
		for (Ansatt p: people) {
			if (p.getAarslonn() > 50) {
				etternavnene.add(p.getEtternavn());
			}
		}
		etternavnene.forEach(System.out::println);
		
		//Example 3
		int[] tall = {2, 3, 4, 5};
		Stream.of(2,3,4,5);
		Stream.of("A","B");
		Stream.of(tall);
		Arrays.stream(tall);
		
		"Hallo".chars();
		
		IntStream.range(1, 10); //stream of numbers 1-9
		IntStream.rangeClosed(1, 10);
		Stream.iterate(1, x -> x + 1);
		
		Paths.get("data.txt");
		
		//Example 4
		IntStream.rangeClosed(1, 10)
				.filter(x -> x % 2 == 0)
				.forEach(x -> System.out.println(x + " "));
		
		IntStream.range(1,10)
				.map(x -> x * 2)
				.forEach(x -> System.out.println(x + " "));
		Stream.iterate(100, x -> x + 3)
				.filter(x -> x % 4 == 0)
				.limit(10)
				.forEach(x -> System.out.println(x + " "));
		//distinct
		Stream.of("A", "X", "A", "B", "F", "P", "X")
				.distinct()
				.forEach(x -> System.out.print(x + " "));
		
		//Example 6
		//forEach
		//collect
		//toArray
		//Ansatt [] ansatte = people.stream().toArray();
		String a = people.stream()
				.map(p -> p.getFornavn().substring(0, 1))
				.reduce( " ", (acc, s) -> acc + s);
		System.out.println(a);
		
		//count 
		long antall = people.stream().count();
		System.out.println(antall);
		
		//anyMatch, allMatch, noneMatch
		boolean match = people.stream().allMatch(p -> p.getAarslonn() > 50);
		System.out.println(match);
		//findFirs, findAny
		//InstStream
	}
}
