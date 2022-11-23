import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        int[][] random = fillMatrixEvenRandomNumbers();
        show(random);

        int[] evenNumbers = evenRandomNumbers(random);
        show(evenNumbers);
    }

    public static int[][] fillMatrixEvenRandomNumbers() {
        int row, col, min, max;
        Scanner sc = new Scanner(System.in);

        System.out.println("Give me the number of rows:");
        row = sc.nextInt();
        System.out.println("Give me the number of columns:");
        col = sc.nextInt();
        System.out.println("Give me the lower random limit:");
        min = sc.nextInt();
        System.out.println("Give me the upper random limit:");
        max = sc.nextInt();

        int[][] matrix = new int[row][col];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = (int) (Math.random() * (max - min + 1)) + min;

        return matrix;
    }

    public static int[] evenRandomNumbers(int[][] matrix) {

        //fill the vector with even numbers
        int[] aux = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = -1;
        }
        int k = 0;
        for (int[] vector : matrix)
            for (int element : vector)
                if ((element % 2 == 0) && !contains(element, aux))
                    aux[k++] = element;

        //fill the vector to return with even numbers
        int[] vector = new int[k];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = aux[i];
        }

        return vector;
    }

    private static boolean contains(int element, int[] vector) {
        boolean contain = false;
        int i = 0;
        while (!contain && i < vector.length) {
            contain = (vector[i] == element);
            i++;
        }
        return contain;
    }

    private static void show(int[][] matrix) {

        for (int[] row : matrix) {
            for (int cel : row)
                System.out.print(cel + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static void show(int[] vector) {
        for (int cel : vector)
            System.out.print(cel + " ");
        System.out.println();
    }

}
