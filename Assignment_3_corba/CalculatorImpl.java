import CalcModule.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class CalculatorImpl extends CalculatorPOA {
    public double add(double a, double b) {
        System.out.println("Add called");
        return a + b;
    }

    public double sub(double a, double b) {
        System.out.println("Sub called");
        return a - b;
    }

    public double mul(double a, double b) {
        System.out.println("Mul called");
        return a * b;
    }

    public double div(double a, double b) {
        System.out.println("Div called");
        if (b == 0)
            return 0;
        return a / b;
    }
}