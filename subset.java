import java.util.*;

public class subset {

    static boolean found = false;

    static void findSubsets(int[] arr, int index, int target,
                            ArrayList<Integer> subset) {

        if (target == 0) {
            System.out.println(subset);
            found = true;
            return;
        }

        if (index == arr.length || target < 0)
            return;

        subset.add(arr[index]);
        findSubsets(arr, index + 1,
                    target - arr[index], subset);

        subset.remove(subset.size() - 1);

        findSubsets(arr, index + 1,
                    target, subset);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.println("Possible Subsets:");

        findSubsets(arr, 0, target,
                    new ArrayList<Integer>());

        if (!found)
            System.out.println("No subset found");
    }
}