package no.hvl.dat108.f06;

import java.util.Random;

public class Eksempel1 {

	public static void main(String[] args) {
		
		//Vi ser her at en Runnable (siden det er et functional interface) 
		//kan defineres som en lambda.
		Runnable r = () -> doSomeWildStuff();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
	
	public static void doSomeWildStuff() {
		Random r = new Random();
		for (int i=1; i<=10; i++) {
				System.out.println(i);
			try {
				Thread.sleep(r.nextInt(100));
			} catch (InterruptedException e) {
			}
		}
	}
}
