import java.util.*;

class Ring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];

        System.out.println("Enter process IDs:");

        for (int i = 0; i < n; i++) {
            process[i] = sc.nextInt();
        }

        System.out.print("Enter initiator index: ");
        int initiator = sc.nextInt();

        int max = process[initiator];

        System.out.print("Election message: " + process[initiator]);

        int i = (initiator + 1) % n;

        while (i != initiator) {
            System.out.print(" -> " + process[i]);
            if (process[i] > max)
                max = process[i];
            i = (i + 1) % n;
        }

        System.out.println("\nNew Leader is: " + max);

        sc.close();
    }
}