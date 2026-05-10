import mpi.*;

public class SumMPI {
    public static void main(String args[]) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int arr[] = {1,2,3,4,5,6,7,8};
        int sum = 0;

        // each process calculates partial sum
        for(int i = rank; i < arr.length; i += size) {
            sum += arr[i];
        }

        int total[] = new int[1];

        // combine all sums
        MPI.COMM_WORLD.Reduce(new int[]{sum}, 0, total, 0, 1, MPI.INT, MPI.SUM, 0);

        if(rank == 0) {
            System.out.println("Total Sum = " + total[0]);
        }

        MPI.Finalize();
    }
}
