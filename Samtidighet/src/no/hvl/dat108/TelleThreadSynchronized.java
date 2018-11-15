package no.hvl.dat108;

/**
 * Tråd som øker en teller med en og skriver den ut.
 * 
 * @author Atle Geitung
 */
public class TelleThreadSynchronized extends Thread {
    private Tall teller;

    /**
     * @param teller
     */
    public TelleThreadSynchronized(Tall teller) {
        this.teller = teller;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (teller) {
                teller.inkrement();
                System.out.println(teller);
            }
        }

    }

}
