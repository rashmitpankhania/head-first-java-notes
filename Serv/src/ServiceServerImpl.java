import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
    HashMap<String, Object> serviceList;

    protected ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    @Override
    public Object[] getServiceList() throws RemoteException {
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }

    @Override
    public Service getService(String serviceKey) throws RemoteException {
        return (Service) serviceList.get(serviceKey);
    }

    void setUpServices(){
        serviceList = new HashMap<>();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Get Day of the week", new DayOfTheWeekService());
        serviceList.put("Get some Music", new MiniMusicService());
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("Service Server", new ServiceServerImpl());
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
