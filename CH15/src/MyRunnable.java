public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(" in ");
        go();
        System.out.println("ou");
    }

    void go(){
        System.out.println("henlo");
    }

    public static void main(String[] args) {
        MyRunnable m = new MyRunnable();
        Thread t = new Thread(m);
        System.out.println("bjhbhjb");
        t.start();
        System.out.println("njknkj");
        m.go();
    }
}
