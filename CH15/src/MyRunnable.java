public class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }

    void go(){
        try {
            Thread.sleep(2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("henlo");
    }

    public static void main(String[] args) {
        MyRunnable m = new MyRunnable();
        Thread t = new Thread(m);
        t.start();
        t.setName("Rash Thread");
        System.out.println("heyy");
    }
}
