import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImple extends UnicastRemoteObject implements MyRemote {
    protected MyRemoteImple() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says hey";
    }

    public static void main(String[] args) {
        try {
            MyRemote r = new MyRemoteImple();
            Naming.rebind("Remote Hello", r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
