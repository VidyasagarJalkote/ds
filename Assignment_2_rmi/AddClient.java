import java.rmi.*;

public class AddClient {

    public static void main(String args[]) {

        try {
            // Lookup remote object
            AddServerIntf addObj = 
                (AddServerIntf) Naming.lookup("rmi://localhost/AddServer");

            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);

            double result = addObj.add(num1, num2);

            System.out.println("Addition Result = " + result);
        }
        catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
