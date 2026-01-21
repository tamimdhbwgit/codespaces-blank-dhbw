public class matrix_multiplication{
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        // Result matrix
        int rowsA = A.length;       // Number of rows in A
        int colsA = A[0].length;   // Number of columns in A
        int colsB = B[0].length;   // Number of columns in B
        int[][] C = new int[rowsA][colsB];
        int sum = 0;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                sum = 0;// Initialize the cell
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        // Print result matrix
        System.out.println("Result Matrix:");
        for (int[] row : C) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println(" ");
        }
    }
}