package no.hvl.dat108.f06;

public class Eksempel4 {
	
	public static Runnable halloRunnable(String id) {
		return () -> System.out.println("Hallo " + id);
	}
	
	public static void main(String[] args) {
		
		//Lage en runnable som sier Hallo
		//Lage og kjøre 2 tråder med denne runnable-en
		//Skulle ønske at de to trådene også skriver ut tråd-id-en.
		
		//Løsning: Må lage en "dynamisk" lambda, dvs. lage en metode som
		//tar en parameter, og som returnerer en lambda basert på denne 
		//parameteren. Se øverst.
		
		Thread t1 = new Thread(halloRunnable("T1"), "T1");
		Thread t2 = new Thread(halloRunnable("T2"), "T2");
		
		t1.start();
		t2.start();
	}
		
}
