package day1.owncode;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Ex1 {
// Exercise 1
    
    // a) the problem with this code is that thread t1 has to finish in order for the rest of them to start and since t1
    // is very slow it will take a while.
    
    // b) we need to synchronize it so they can
    
    // c) if its syncronized then the threads can execute without slowing each other down
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (long i = 1; i < 1e8; i++) {
                System.out.println(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (long i = 1; i < 6; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread t3 = new Thread(() -> {
            int i = 10;
            long time = System.currentTimeMillis();
            long end = time + 10000;
            while (System.currentTimeMillis() < end) {
                i++;
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // t1.start();
        // t2.start();
        t3.start();

    }
}
