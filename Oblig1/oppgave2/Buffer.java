package oppgave2;

import java.util.LinkedList;

/**
 * A shared buffer for consumers and producers. The item type is int. The buffer
 * is implemented by using a double ended queue.
 *
 * @author Atle Geitung
 * @version 17.05.2018 C++ version
 * @version 30.08.2018 Java version
 */
public class Buffer {

    private final static int SIZE = 10;
    private LinkedList<Integer> buffer = new LinkedList<Integer>();

    /**
     * Add a new item to the buffer. If the buffer is full, wait.
     *
     * @param item the new item
     */
    public void add (Integer item) {
    	while(true) {
    		if (buffer.size() < SIZE) {
    			buffer.add(item);
    		} else {
    			try {
    				Thread.sleep(50);
    			} catch (InterruptedException e) {
    				System.out.checkError();
    			}
    		}
    		return;
    	}
    }

    /**
     * Remove next available item from the buffer. If the buffer is empty, wait.
     *
     * @return next item
     */
    public Integer remove() {
    	Integer back = 0;
        while (true) {
            if (!buffer.isEmpty()) {
            	back = buffer.removeFirst();
            } else {
            	try {
            		Thread.sleep(50);
            	} catch (InterruptedException e) {
            		System.out.checkError();
            	}
            }
            return back;
        }
    }

}
