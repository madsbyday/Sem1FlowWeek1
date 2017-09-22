/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

class DeadLockDetector extends Thread {

    ThreadMXBean bean = ManagementFactory.getThreadMXBean();

    public void run() {
        while (true) {
            long[] threadIds = bean.findDeadlockedThreads();
            if (threadIds == null) {
                System.out.println("Deadlock Detected");
                break;
            }
        }
    }
}
