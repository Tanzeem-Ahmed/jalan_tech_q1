// Write a program that takes as input an array of positive and negative numbers (0 excluded). The objective is to
// return those items from the array whose sum is 0. If no such items exist return No Elements found

// Example: For an input array [-4, 1, 3, -2, -1],
// one of the possible results would be 3, -2, -1 since their sum is 0.

// Note: If there are more than 1 combination of such items, you can return any 1 of them.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // time complexity - O(n), space complexity - O(n) since we
    // are using HashMap data structure
    public static int[] subarraySumZero(int arr[]) {
        int res[] = new int[2];
        // filling the array with -1 if res is not found
        Arrays.fill(res, -1);

        // Create a hashMap that stores index of the prefix sum
        HashMap<Integer, Integer> h = new HashMap<>();
        // initialise prefix sum
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // if at any point prefix sum is zero then from zero index to that index
            // subarray sum will be zero
            if (sum == 0) {
                res[0] = 0;
                res[1] = i;
                return res;
            }

            // if the sum already exist then there is a subarray from the next index to
            // current index whose sum will be zero
            if (h.containsKey(sum)) {
                res[0] = h.get(sum) + 1;
                res[1] = i;
                return res;
            }
            // put the prefix sum and index in the HashMap
            h.put(sum, i);
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Taking the size of the input array
        int size = sc.nextInt();
        // Creating the array with given input size
        int arr[] = new int[size];

        // taking user input for array
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        sc.close();
        // Storing the starting and ending index of elements whose sum equal to zero
        int res[] = subarraySumZero(arr);
        // if there are no such elements
        if (res[0] == -1) {
            System.out.println("No Elements found");
            return;
        }
        // Printing the resultant elements
        for (int i = res[0]; i <= res[1]; i++)
            System.out.print(arr[i] + " ");
    }
}
