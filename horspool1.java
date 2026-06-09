import java.util.*;

public class horspool1 {

    static int NO_OF_CHARS = 256;

    static void shiftTable(String pattern, int[] table) {

        int m = pattern.length();

        for (int i = 0; i < NO_OF_CHARS; i++)
            table[i] = m;

        for (int j = 0; j < m - 1; j++)
            table[(int) pattern.charAt(j)] = m - 1 - j;
    }

    static int horspoolSearch(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        int[] table = new int[NO_OF_CHARS];
        shiftTable(pattern, table);

        int i = m - 1;

        while (i < n) {

            int k = 0;

            while (k < m &&
                   pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k++;
            }

            if (k == m)
                return i - m + 1;

            i += table[text.charAt(i)];
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine().toUpperCase();

        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine().toUpperCase();

        int pos = horspoolSearch(text, pattern);

        if (pos != -1)
            System.out.println("Pattern found at position: " + pos);
        else
            System.out.println("Pattern not found");

        sc.close();
    }
}