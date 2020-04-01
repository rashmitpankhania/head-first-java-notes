public class TestThreads {
    Accum a = Accum.getAccum();

    class ThreadOne implements Runnable {
        @Override
        public void run() {
            for (int x = 0; x < 98; x++) {
                a.updateCounter(1000);
            }
        }
    }

    static class ThreadTwo implements Runnable {
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();

        Thread one = new Thread(t1);
        Thread two = new Thread(t2);
    }
}
 /*
 incomplete
  */