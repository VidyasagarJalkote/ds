import java.util.*;

class TokenRing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int token = 0; // initial token with process 0

        while (true) {

            System.out.println("\nToken is with Process " + token);

            System.out.print("Does Process " + token + " want to enter CS? (1/0): ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Process " + token + " is in Critical Section...");
                System.out.println("Process " + token + " exiting Critical Section...");
            }

            // pass token to next process
            token = (token + 1) % n;

            System.out.print("Continue? (1/0): ");
            int cont = sc.nextInt();

            if (cont == 0)
                break;
        }

        sc.close();
    }
}