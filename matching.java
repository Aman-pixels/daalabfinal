import java.util.*;

public class matching {

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

        String[] men = {"A", "B", "C", "D"};
        String[] women = {"W", "X", "Y", "Z"};

        String[][] menPref = {
                {"W", "X", "Y", "Z"},
                {"X", "W", "Y", "Z"},
                {"Z", "W", "Y", "X"},
                {"Z", "Y", "X", "W"}
        };

        String[][] womenPref = {
                {"A", "B", "D", "C"},
                {"B", "C", "A", "D"},
                {"C", "D", "A", "B"},
                {"C", "D", "B", "A"}
        };

        int n = men.length;

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

        System.out.println("Stable Marriages:");

        for (int i = 0; i < n; i++) {
            System.out.println(
                    men[womenPartner[i]] + " - " + women[i]);
        }
    }
}