import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject 
                           implements AddServerIntf {

    public AddServerImpl() throws RemoteException {
        super();
    }

    // This method will be executed remotely
    public double add(double num1, double num2) 
            throws RemoteException {

        System.out.println("Processing request in thread: " 
                           + Thread.currentThread().getName());

        return num1 + num2;
    }
}
