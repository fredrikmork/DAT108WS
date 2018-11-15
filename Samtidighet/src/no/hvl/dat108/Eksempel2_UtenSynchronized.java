package no.hvl.dat108;

/**
 * Viser bruk av synchronize.
 * 
 * @author Atle Geitung
 */
public class Eksempel2_UtenSynchronized {
    
    private static Tall deltTeller = new Tall(0);

    /**
     * @param args ikke i bruk
     * @throws InterruptedException 
     */
    public static void main(String[] args) {
        Thread teller1 = new TelleThread(deltTeller);
        Thread teller2 = new TelleThread(deltTeller);
        Thread teller3 = new TelleThread(deltTeller);

        teller1.start();
        teller2.start();
        teller3.start();
    }
}
