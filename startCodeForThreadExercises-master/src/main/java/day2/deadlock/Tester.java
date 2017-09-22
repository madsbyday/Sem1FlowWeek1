package day2.deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Tester {
  public static void main(String[] args) {
    
      // a) One of the resource users locks the getResourceWords(), the other resource then cant access it so it moves on to
      // getResourceNumbers() and locks it. but in order for the function to finish they have to unlock the methods but since they cant get to
      // that part of the code it reaches a deadlock
    try {
      DeadLockDetector dld = new DeadLockDetector();
      dld.start();
      ResourceContainer resources = new ResourceContainer();
      ResourceUser1 t1 = new ResourceUser1(resources);
      ResourceUser2 t2 = new ResourceUser2(resources);
      t1.start();
      t2.start();
          
      t1.join();
      t2.join();
      
      System.out.println("Done");
      System.out.println("Words produced: "+resources.getResourceWords().size());
      System.out.println("Numbers produced: "+resources.getResourceNumbers().size());
    } catch (InterruptedException ex) {
      Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
