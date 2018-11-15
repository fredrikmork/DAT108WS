package no.hvl.dat108;

/**
 * Eksempel på å lage en tråd.
 * 
 * @author Atle Geitung
 */
public class Eksempel1_MedJoin {

    /**
     * @param args ikke i bruk
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        Thread helloRunnable = new Thread(new HelloWorldRunnable());
        Thread helloThread = new HelloWorldThread();
        
        helloRunnable.start();
        helloThread.start();
        helloRunnable.join();
        helloThread.join();
        System.out.println("End");
    }

}
