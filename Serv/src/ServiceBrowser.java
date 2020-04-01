import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class ServiceBrowser {
    JPanel mainPanel;
    JComboBox<Object> serviceList;
    ServiceServer server;

    void buildGui() {
        JFrame frame = new JFrame("Banana Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        try {
            Object[] services = server.getServiceList();
            serviceList = new JComboBox<>(services);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
