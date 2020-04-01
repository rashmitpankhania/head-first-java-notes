public class RunThreads implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<25;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        RunThreads r = new RunThreads();
        Thread a = new Thread(r);
        Thread b = new Thread(r);

        a.setName("Rash");
        b.setName("Madhu");

        a.start();
        b.start();
    }
}
