package no.hvl.dat108;

/**
 * Hello World thread.
 * 
 * @author Atle Geitung
 */
public class HelloWorldThread extends Thread {

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
//            System.out.println("Interrupted");
//            return;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World! " + i);
        }
    }

}
