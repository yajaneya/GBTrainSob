package dz3;

import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private Long counter = 0L;
    private final Lock lock = new ReentrantLock();

    public void increaseCounter() {

        try {
            lock.lock();
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public long getCounter () {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < 200; i++) {
            CountThread ct = new CountThread(counter);
            ct.start();
        }

        Thread.sleep(1000);

        System.out.println("Counter: " + counter.getCounter());
    }

}

class CountThread extends Thread {
    private final Counter counter;

    public CountThread (Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();
        }
    }
}
