import java.util.*;

class Berkeley {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] time = new int[n];
        int sum = 0;

        // Input time of each node
        for (int i = 0; i < n; i++) {
            System.out.print("Enter time for node " + i + ": ");
            time[i] = sc.nextInt();
            sum += time[i];
        }

        // Calculate average time
        int avg = sum / n;

        System.out.println("\nAverage time = " + avg);

        // Calculate adjustments
        System.out.println("\nTime adjustments:");

        for (int i = 0; i < n; i++) {
            int diff = avg - time[i];
            System.out.println("Node " + i + " adjust by: " + diff);
            time[i] += diff;
        }

        // Display synchronized time
        System.out.println("\nSynchronized times:");

        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + time[i]);
        }

        sc.close();
    }
}