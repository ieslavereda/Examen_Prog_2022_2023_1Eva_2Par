import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] heights = {
                {"Peter", "1.85"},
                {"John", "1.86"},
                {"Thomas", "1.78"},
                {"Carl", "1.62"},
                {"Lewis", "1.68"},
                {"Michael", "1.65"},
                {"Vanessa", "1.70"},
                {"Anne", "1.69"}
        };

        System.out.print("Person's name to search: ");
        String name  = sc.next();
        bubble(heights);
        show(heights);
        System.out.println("Recursively: " + recursiveSearch(heights, name));
        System.out.println("Iteratively: " + iterativeSearch(heights, name));

        sc.close();
    }
    // Only for testing
    private static void show(String[][] heights) {
        for (String[] person : heights) {
            for (String data : person)
                System.out.print(data + "\t");
            System.out.println();
        }
    }

    // Sort
    public static void bubble(String[][] array) {
        int i, j;

        for (i = 1; i < array.length; i++) {
            for (j = 0; j < array.length - 1; j++) {
                if (array[j][0].compareTo(array[j + 1][0])>0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(String[][] arreglo, int j, int i) {
        String[] aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }

    // Recursive
    private static String recursiveSearch(String[][] heights, String name) {
        return binarySearch(heights, 0, heights.length - 1, name);
    }

    private static String binarySearch(String[][] heights, int i, int d, String name) {

        int m = (d + i) / 2;

        if (heights[m][0].equals(name)) {
            return heights[m][1];
        } else if (d < i) {
            return "The name \"" + name + "\" was not found.";
        } else if (heights[m][0].compareTo(name) < 0)
            return binarySearch(heights, i + 1, d, name);
        else
            return binarySearch(heights, i, d - 1, name);
    }

    // Iterative
    private static String iterativeSearch(String[][] heights, String name) {

        int pos = 0;

        while (pos < heights.length && !heights[pos][0].equals(name))
            pos++;

        if (pos >= heights.length)
            return "The name \"" + name + "\" was not found.";
        else
            return heights[pos][1];
    }
}
