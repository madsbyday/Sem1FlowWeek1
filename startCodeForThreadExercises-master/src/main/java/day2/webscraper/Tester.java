package day2.webscraper;

public class Tester {
    // a) It takes a lot of time because all the of the tagcounters use the same thread(main thread)
    // b) It still uses the same run method it just overrides it
    // c) This will start three seperate threads whitch start. In order to fix the the problem (all of the return null/0) we have to join the threads
    // d) It takes a lot less time if you use the start since they dont have to wait for each other

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

        TagCounter tc1 = new TagCounter("http://www.fck.dk");
        tc1.start();
        TagCounter tc2 = new TagCounter("http://www.google.com");
        tc2.start();
        TagCounter tc3 = new TagCounter("http://politiken.dk/");
        tc3.start();

        tc1.join();
        tc2.join();
        tc3.join();

        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());

        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());

        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());

        long end = System.nanoTime();
        System.out.println("Time Sequential: " + (end - start));
    }
}
