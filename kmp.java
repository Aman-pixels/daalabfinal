import java.util.*;

public class kmp {

    static void computeLPS(String pat, int[] lps) {

        int len = 0;
        int i = 1;

        while (i < pat.length()) {

            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static void KMPSearch(String pat, String txt) {

        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M];

        computeLPS(pat, lps);

        int i = 0;
        int j = 0;

        while (i < N) {

            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            }

            else if (i < N && pat.charAt(j) != txt.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine();

        KMPSearch(pattern, text);
    }
}