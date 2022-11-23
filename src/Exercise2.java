public class Exercise2 {
    public static void main(String[] args) {

        int[][] matrix = { { 1, 3, 0 }, { 5, 3, 5 }, { 4, 9, 6 }, { 8, 7, 4 } };
        int[][] positions;

        show(matrix);
        int count = countEvenElements(matrix);

        System.out.println("The count of all even elements is: " + count);
        positions = getOddPosition(matrix, count);

        for(int[] position : positions)
            System.out.println("There even number " + matrix[position[0]][position[1]] + " is in the row " + position[0] + " col " + position[1]);

    }

    private static int[][] getOddPosition(int[][] matrix, int size) {
        int[][] positions = new int[size][2];
        int i = 0;// Index used to store a position in the positions array
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++)
                if (matrix[row][col] % 2 == 0)
                    positions[i++] = new int[] { row, col };
        return positions;
    }

    private static int countEvenElements(int[][] matrix) {

        int count = 0;

        for (int[] vector : matrix)
            for (int element : vector)
                if (element % 2 == 0)
                    count++;
        return count;
    }

    private static void show(int[][] matrix) {

        for (int[] row : matrix) {
            for (int cel : row)
                System.out.print(cel + " ");
            System.out.println();
        }
        System.out.println();
    }
}
