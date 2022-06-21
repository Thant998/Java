
class SleepThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("This is thread 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread 1 interrupted");
            }
        }
    }
}

class SleepThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("This is thread 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread 2 interrupted");
            }
        }
    }
}

public class Multithreading_3 {
    public static void main(String[] args) {
        SleepThread1 t1 = new SleepThread1();
        SleepThread2 t2 = new SleepThread2();

        t1.start();
        t2.start();
    }
}