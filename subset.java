import java.util.*;

public class subset {

    static boolean subsetSum(int arr[],
                             int n,
                             int sum) {

        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (arr[n - 1] > sum)
            return subsetSum(arr, n - 1, sum);

        return subsetSum(arr, n - 1, sum)
                || subsetSum(arr, n - 1,
                             sum - arr[n - 1]);
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
        int sum = sc.nextInt();

        if (subsetSum(arr, n, sum))
            System.out.println("Subset Exists");
        else
            System.out.println("Subset Does Not Exist");
    }
}