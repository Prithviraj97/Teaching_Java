class MyThread extends Thread { 
    public void run() {
        System.out.println("Hello, I am a thread");
    }
}
public class thread {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
