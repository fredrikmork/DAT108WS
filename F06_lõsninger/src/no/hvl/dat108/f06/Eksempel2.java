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

		
		// 1: Sorter personene på etternavn.
		Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		// 2: Skriv ut alle personene, én linje per person. 
		// 		Lag en egen hjelpemetode printAll(...) som gjør dette. 
		printAll(people);
		
		// 3: Skriv ut alle personene som har etternavn som begynner på C.
		//		Lag en egen hjelpemetode printLastNameStartsWithC(...) som gjør dette. 
		printLastNameStartsWithC(people);
		
		// 4: Skriv ut alle personene som har fornavn som begynner på C.
		//		Vi ser nå at det er tungvint å lage én utskriftsmetode per
		//      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
		//		gjør jobben i stedet. Denne tar inn listen + et lambdauttrykk.
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
		
		// 5: Skriv ut ALLE personene ved å bruke printConditionally(...)
		printConditionally(people, p -> true);
		
		// Eksempel3: For å vise forhåndsdefinerte funksjonelle kontrakter,
		// se definisjonen av doConditionally() under.
		// Eksempel5: Bruke metodereferanse på p -> System.out.println(p)
		doConditionally(people, p -> p.getAge() > 50, System.out::println);
		
		// Eksempel5: Bruke metodereferanse på aldersdiff
		Collections.sort(people, Eksempel2::aldersdiff);
		printAll(people);
	}
	
	private static int aldersdiff(Person p1, Person p2) {
		return p1.getAge() - p2.getAge();
	}

	//Dette er den mest generelle. De andre kan nå "fjernes" !!!
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
