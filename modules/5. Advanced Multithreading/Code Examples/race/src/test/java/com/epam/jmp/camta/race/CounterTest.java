package com.epam.jmp.camta.race;

import org.junit.Test;

public class CounterTest {

    private static final int ITERATIONS = 10;

    @Test
    public void testMultiThreadCounter() throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterThread(counter, 2), "thread-1");
        Thread thread2 = new Thread(new CounterThread(counter, 3), "thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private class CounterThread implements Runnable {

        private final Counter counter;

        private final int increment;

        CounterThread(Counter counter, int increment) {
            this.counter = counter;
            this.increment = increment;
        }

        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                System.out.println(Thread.currentThread() + ": " + counter.add(increment));
            }
        }
    }
}
