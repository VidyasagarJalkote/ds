import java.util.*;

class Bully {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];

        System.out.println("Enter process IDs:");

        for (int i = 0; i < n; i++) {
            process[i] = sc.nextInt();
        }

        System.out.print("Enter process that detects failure: ");
        int initiator = sc.nextInt();

        int leader = initiator;

        for (int i = 0; i < n; i++) {
            if (process[i] > leader) {
                System.out.println("Process " + process[i] + " responds");
                leader = process[i];
            }
        }

        System.out.println("New Leader is: " + leader);

        sc.close();
    }
}