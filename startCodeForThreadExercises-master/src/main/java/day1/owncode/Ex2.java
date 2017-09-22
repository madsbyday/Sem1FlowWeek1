/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1.owncode;

public class Ex2 {
// Exercise 2

    // a) I am able to provoke the race condition error
    // b) It has occured every time i've run the program
    // c) I have
    public static void main(String[] args) {
        Even e = new Even();

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1e5; i++) {
                System.out.println("t1: " + e.next());
            }
        });
        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1e5; i++) {
                System.out.println("t2: " + e.next());
            }
        });
        t1.start();
        t2.start();
    }
}
