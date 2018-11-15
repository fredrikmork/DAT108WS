package oppgave2;

public class Klient {
	/**
	 * main program som kjører trådene
	 * @param args
	 */
	public static void main(String[] args) {
		
		//private static Point deltTeller = new Point(0.0 , 0.0);
		Buffer buffer = new Buffer();
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
	}
	/*
	 * d)
	 * 
	 * Synchronized i Java har å gjøre med trådsikkerhet, 
	 * det vil si når flere tråder leser eller skriver den samme variabelen.
	 * Dette kan skje direkte (ved å få tilgang til samme variabel) eller indirekte 
	 * (ved å bruke en klasse som bruker en annen klasse som får tilgang til samme variabel).
	 * Synchronized brukes til å definere en blokk med kode der flere tråder 
	 * kan få tilgang til samme variabel på en trygg måte.
	 * 
	 */
}
