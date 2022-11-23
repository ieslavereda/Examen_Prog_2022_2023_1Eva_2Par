import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {

        int row,col;
        Scanner sc = new Scanner(System.in);

        System.out.println("Give me the number of rows:");
        row = sc.nextInt();
        System.out.println("Give me the number of columns:");
        col = sc.nextInt();

        String[][] array = new String[row][col];
        fill(array);
        show(array);
        int sum = sumArray(array);
        System.out.println("The sum is: " + sumArray(array));
        System.out.println("The average is: " + avgArray(sum, array.length*array[0].length));

    }

    private static double avgArray(int sum, int length) {
        return (double) sum/length;
    }

    private static int sumArray(String[][] array) {
        int sum = 0;
        for (String[] row : array)
            for (int col = 0; col < array[0].length; col++)
                sum += Integer.parseInt(row[col]);
        return sum;
    }

    private static void fill(String[][] array) {
        for(int row = 0 ; row < array.length;row++)
            for (int col=0;col<array[0].length;col++)
                array[row][col]="" + row + col;
    }

    private static void show(String [][] matrix) {

        for(String[] row : matrix) {
            for(String cel : row)
                System.out.print(cel + " ");
            System.out.println();
        }
    }

}