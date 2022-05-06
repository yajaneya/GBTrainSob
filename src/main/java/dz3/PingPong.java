package dz3;

public class PingPong {
    public static void main(String[] args) {
        SyncQueue q = new SyncQueue();
        new Ping(q);
        new Pong(q);
    }
}

class Ping implements Runnable{
    SyncQueue q;
    public Ping(SyncQueue q){
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true){
            q.ping();
        }
    }
}

class Pong implements Runnable{
    SyncQueue q;
    public Pong(SyncQueue q){
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true){
            q.pong();
        }
    }
}
class SyncQueue {
    boolean flag = false;
    synchronized void ping() {
        while (!flag){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("ping");
        flag = false;
        notify();
    }
    synchronized void pong() {
        while (flag) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("pong");
        flag = true;
        notify();
    }
}