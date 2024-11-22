class NumberPrinter implements Runnable {
    private int start;
    public NumberPrinter(int start) {
        this.start = start;
    }
    public void run() {
        for (int i = start; i < start + 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}

public class mutlithread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new NumberPrinter(1));
        Thread t2 = new Thread(new NumberPrinter(6));

        t1.start();
        t2.start();
    }
}
