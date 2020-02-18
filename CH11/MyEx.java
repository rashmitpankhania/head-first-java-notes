class MyException extends Exception {
}

class MyEx {
    static void doRisky(String t) throws MyException {
        System.out.print("h");
        if ("yes".equals(t)) {
            System.out.print("a");
            throw new MyException();
        }
    }

    public static void main(String[] args) {
        System.out.print("t");
        try {
            doRisky(args[0]);
            System.out.print("ro");
        } catch (MyException e) {
        } finally {
            System.out.print("ws");
        }
    }
}