import java.util.*;

public class matching1 {

    static boolean womanPrefersNewMan(String[][] womenPref, int womanIndex,
                                      String newMan, String currentMan) {

        for (int i = 0; i < womenPref[womanIndex].length; i++) {

            if (womenPref[womanIndex][i].equals(newMan))
                return true;

            if (womenPref[womanIndex][i].equals(currentMan))
                return false;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of men/women: ");
        int n = sc.nextInt();

        String[] men = new String[n];
        String[] women = new String[n];

        System.out.println("\nEnter names of men:");
        for (int i = 0; i < n; i++) {
            men[i] = sc.next();
        }

        System.out.println("\nEnter names of women:");
        for (int i = 0; i < n; i++) {
            women[i] = sc.next();
        }

        String[][] menPref = new String[n][n];
        String[][] womenPref = new String[n][n];

        System.out.println("\nEnter preference list for each man:");

        for (int i = 0; i < n; i++) {

            System.out.println("Preferences of " + men[i] + ":");

            for (int j = 0; j < n; j++) {
                menPref[i][j] = sc.next();
            }
        }

        System.out.println("\nEnter preference list for each woman:");

        for (int i = 0; i < n; i++) {

            System.out.println("Preferences of " + women[i] + ":");

            for (int j = 0; j < n; j++) {
                womenPref[i][j] = sc.next();
            }
        }

        int[] womenPartner = new int[n];
        boolean[] menFree = new boolean[n];
        int[] nextProposal = new int[n];

        Arrays.fill(womenPartner, -1);

        int freeMen = n;

        while (freeMen > 0) {

            int m;

            for (m = 0; m < n; m++) {
                if (!menFree[m])
                    break;
            }

            int wIndex = -1;

            for (int i = nextProposal[m]; i < n; i++) {

                String woman = menPref[m][i];

                for (int j = 0; j < n; j++) {
                    if (women[j].equals(woman)) {
                        wIndex = j;
                        break;
                    }
                }

                nextProposal[m]++;

                if (womenPartner[wIndex] == -1) {

                    womenPartner[wIndex] = m;
                    menFree[m] = true;
                    freeMen--;
                    break;

                } else {

                    int currentPartner = womenPartner[wIndex];

                    if (womanPrefersNewMan(
                            womenPref,
                            wIndex,
                            men[m],
                            men[currentPartner])) {

                        womenPartner[wIndex] = m;
                        menFree[m] = true;
                        menFree[currentPartner] = false;
                        break;
                    }
                }
            }
        }

        System.out.println("\nStable Marriages:");

        for (int i = 0; i < n; i++) {
            System.out.println(men[womenPartner[i]] + " - " + women[i]);
        }

        sc.close();
    }
}