
class MyThreadClass1 extends Thread {
    public void run() {
        int i = 0;
        while (i < 10) {
            System.out.println("This is thread 1");
            i++;
        }
    }
}

class MyThreadClass2 extends Thread {
    public void run() {
        int i = 0;
        while (i < 10) {
            System.out.println("This is thread 2");
            i++;
        }
    }
}

public class Multithreading_2 {
    public static void main(String[] args) {
        MyThreadClass1 t1 = new MyThreadClass1();
        MyThreadClass2 t2 = new MyThreadClass2();

        t1.start();
        t2.start();
    }
}