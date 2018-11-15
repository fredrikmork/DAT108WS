package no.hvl.dat108.f06;
/* Kopiert fra javabrains.io sitt Java 8 Lambda Basics kurs */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Eksempel2 {
	
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		
		// 1: Sorter personene p� etternavn.
		Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		// 2: Skriv ut alle personene, �n linje per person. 
		// 		Lag en egen hjelpemetode printAll(...) som gj�r dette. 
		printAll(people);
		
		// 3: Skriv ut alle personene som har etternavn som begynner p� C.
		//		Lag en egen hjelpemetode printLastNameStartsWithC(...) som gj�r dette. 
		printLastNameStartsWithC(people);
		
		// 4: Skriv ut alle personene som har fornavn som begynner p� C.
		//		Vi ser n� at det er tungvint � lage �n utskriftsmetode per
		//      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
		//		gj�r jobben i stedet. Denne tar inn listen + et lambdauttrykk.
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
		
		// 5: Skriv ut ALLE personene ved � bruke printConditionally(...)
		printConditionally(people, p -> true);
		
		// Eksempel3: For � vise forh�ndsdefinerte funksjonelle kontrakter,
		// se definisjonen av doConditionally() under.
		// Eksempel5: Bruke metodereferanse p� p -> System.out.println(p)
		doConditionally(people, p -> p.getAge() > 50, System.out::println);
		
		// Eksempel5: Bruke metodereferanse p� aldersdiff
		Collections.sort(people, Eksempel2::aldersdiff);
		printAll(people);
	}
	
	private static int aldersdiff(Person p1, Person p2) {
		return p1.getAge() - p2.getAge();
	}

	//Dette er den mest generelle. De andre kan n� "fjernes" !!!
	private static void doConditionally(List<Person> people, 
			Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p : people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}

//	private static void printConditionally(List<Person> people, Predicate<Person> predikat) {
//		for (Person p : people) {
//			if (predikat.test(p)) {
//				System.out.println(p);
//			}
//		}
//	}
	private static void printConditionally(List<Person> people, Predicate<Person> predikat) {
		doConditionally(people, predikat, System.out::println);
	}

//	private static void printLastNameStartsWithC(List<Person> people) {
//		for (Person p : people) {
//			if (p.getLastName().startsWith("C")) {
//				System.out.println(p);
//			}
//		}
//	}
	private static void printLastNameStartsWithC(List<Person> people) {
		doConditionally(people, p -> p.getLastName().startsWith("C"), System.out::println);
	}

//	private static void printAll(List<Person> people) {
//		for (Person p : people) {
//			System.out.println(p);
//		}
//	}
	private static void printAll(List<Person> people) {
		doConditionally(people, p -> true, System.out::println);
	}
}
