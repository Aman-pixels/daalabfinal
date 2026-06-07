import java.util.*;

public class boyermoore {

    static final int NO_OF_CHARS = 256;

    static void badCharHeuristic(String str, int size, int badchar[]) {

        Arrays.fill(badchar, -1);

        for (int i = 0; i < size; i++)
            badchar[(int) str.charAt(i)] = i;
    }

    static void search(String txt, String pat) {

        int m = pat.length();
        int n = txt.length();

        int[] badchar = new int[NO_OF_CHARS];

        badCharHeuristic(pat, m, badchar);

        int s = 0;

        while (s <= (n - m)) {

            int j = m - 1;

            while (j >= 0 &&
                   pat.charAt(j) == txt.charAt(s + j))
                j--;

            if (j < 0) {

                System.out.println("Pattern found at index " + s);

                s += (s + m < n)
                        ? m - badchar[txt.charAt(s + m)]
                        : 1;
            }

            else {

                s += Math.max(1,
                        j - badchar[txt.charAt(s + j)]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine();

        search(text, pattern);
    }
}