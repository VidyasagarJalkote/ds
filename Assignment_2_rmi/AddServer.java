import java.rmi.*;
import java.rmi.registry.*;

public class AddServer {

    public static void main(String args[]) {

        try {
            AddServerImpl addObj = new AddServerImpl();

            // Register object with RMI registry
            Naming.rebind("AddServer", addObj);

            System.out.println("Server Started...");
        }
        catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}
