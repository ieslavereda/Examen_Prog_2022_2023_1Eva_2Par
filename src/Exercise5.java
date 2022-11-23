public class Exercise5 {

    public static void main(String[] args) {

        System.out.println("Exercise (a)");
        System.out.println("Recursive");
        System.out.println(count7(7));
        System.out.println(count7(717));
        System.out.println(count7(7717));
        System.out.println(count7(123));
        System.out.println(count7(77877));
        System.out.println("Iterative");
        System.out.println(count7it(7));
        System.out.println(count7it(717));
        System.out.println(count7it(7717));
        System.out.println(count7it(123));
        System.out.println(count7it(77877));

        System.out.println("Exercise (b)");
        System.out.println("Recursive");
        System.out.println("compare(\"plane\",\"zoo\") → " + compare("plane", "zoo"));
        System.out.println("compare(\"zoo\",\"plane\") → " + compare("zoo", "plane"));
        System.out.println("compare(\"zoo\",\"zoo\") → " + compare("zoo", "zoo"));
        System.out.println("Iterative");
        System.out.println("compare(\"plane\",\"zoo\") → " + compareIteratively("plane", "zoo"));
        System.out.println("compare(\"zoo\",\"plane\") → " + compareIteratively("zoo", "plane"));
        System.out.println("compare(\"zoo\",\"zoo\") → " + compareIteratively("zoo", "zoo"));

    }

    // Exercise 5a
    // Recursive
    public static int count7(int n) {
        if (n / 10 == 0) {
            if (n % 10 == 7) return 1;
            else return 0;
        } else {
            if (n % 100 == 77) return 2 + count7(n / 10);
            else if (n % 10 == 7) return 1 + count7(n / 10);
            else return 0 + count7(n / 10);
        }
    }

    // Exercise 5a
    // Iterative
    public static int count7it(int n) {
        int i = 0;
        while (n / 10 > 0) {
            if (n % 100 == 77) i += 2;
            else if (n % 10 == 7) i++;
            n = n/10;
        }
        if (n % 10 == 7) i++;

        return i;
    }

    // Exercise 5b
    // Recursive
    public static int compare(String str1, String str2) {
        if (str1.equals("") && str2.equals("")) return 0;
        if (str1.equals("")) return -1;
        if (str2.equals("")) return 1;
        if (str1.charAt(0) != str2.charAt(0)) return (str1.charAt(0) < str2.charAt(0)) ? -1 : 1;
        else
            return compare(str1.substring(1), str2.substring(1));
    }

    // Exercise 5a
    // Iterative
    public static int compareIteratively(String str1, String str2) {

        int i = 0;

        while (i < str1.length() && i < str2.length() && str1.charAt(0) == str2.charAt(0))
            i++;

        if (i == str1.length() && i == str2.length()) return 0;
        if (i == str1.length()) return -1;
        if (i == str2.length()) return 1;
        else return (str1.charAt(i) < str2.charAt(i)) ? -1 : 1;

    }
}
