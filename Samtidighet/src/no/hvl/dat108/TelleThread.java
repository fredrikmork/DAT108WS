package no.hvl.dat108;

/**
 * Tråd som øker en teller med en og skriver den ut.
 * 
 * @author Atle Geitung
 */
public class TelleThread extends Thread {
    private Tall teller; 

    /**
     * @param teller
     */
    public TelleThread(Tall teller) {
        this.teller = teller;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            teller.inkrement();
            System.out.println(teller);
        }
    }
    
}
