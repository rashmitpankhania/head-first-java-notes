public class Concurrency implements Runnable {
    private int balance;

    @Override
    public void run() {
        for(int i=0;i<50;i++){
            increment();
            System.out.println("balance is "+balance);
        }
    }

    void increment(){
        synchronized (this) {
            int i = balance;
            balance = i + 1;
        }
    }

    public static void main(String[] args) {
        Concurrency c = new Concurrency();

        Thread a = new Thread(c);
        Thread b = new Thread(c);

        a.start();
        b.start();

    }
}
