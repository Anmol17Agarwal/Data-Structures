package TwoPointer;

import java.util.Arrays;

/**
 * This class demonstrates the problem of removing duplicates
 * from a sorted array using the Two-Pointer technique.
 *
 * It contains:
 * 1. My first attempt (incorrect approach)
 * 2. The correct, optimized two-pointer solution
 *
 * The comments explain the mistakes I learned from,
 * and why the two-pointer technique is the correct approach.
 */
public class RemoveDuplicatesFromASortedArray {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println("Correct Two-Pointer Solution:");
        correctAnswer(arr);
    }

    /**
     * =============================
     *  CORRECT TWO-POINTER APPROACH
     * =============================
     *
     * - Works in O(n) time
     * - Uses O(1) extra space
     * - Does NOT use swap()
     * - DOES NOT modify order incorrectly
     *
     * Logic:
     *  i = slow pointer (tracks last unique index)
     *  j = fast pointer (scans ahead for new unique values)
     *
     * When arr[j] != arr[i], we found a new unique value.
     * Move i forward and overwrite arr[i] = arr[j].
     */
    public static void correctAnswer(int[] arr) {
        int i = 0;  // slow pointer

        for (int j = 1; j < arr.length; j++) {  // fast pointer
            if (arr[j] != arr[i]) {             // new unique element found
                i++;
                arr[i] = arr[j];                // overwrite next unique position
            }
        }

        System.out.println("Unique elements count = " + (i + 1));
        System.out.println("Array after removing duplicates: " + Arrays.toString(arr));
    }


    /**
     * ================================================================
     *                    ❌ MY FIRST ATTEMPT (WRONG APPROACH)
     * ================================================================
     *
     * Mistakes Learned:
     * 1. Using swap() breaks the sorted order and creates garbage values.
     * 2. Incrementing j twice causes skipping elements unintentionally.
     * 3. The extra condition arr[i] < arr[j] was unnecessary.
     * 4. Two-pointer technique should use *overwrite* instead of swap.
     *
     * This attempt helped me understand why the correct two-pointer
     * pattern works and why swap-based logic fails.
     */
    public static void firstAttempt(int[] arr){
        int i = 0;
        int j = 1;

        while (j < arr.length) {
            if (arr[i] != arr[j] && arr[i] < arr[j]) {
                swap(arr, j, i + 1); // ❌ Wrong: swapping disturbs ordering
                i++;
                j++;                 // ❌ Wrong: incrementing inside AND outside loop
            }
            j++;                     // ❌ j increments twice → skips values
        }

        System.out.println("First attempt output (incorrect logic): " + Arrays.toString(arr));
        System.out.println("Calculated unique count: " + (i + 1));
    }

    /**
     * Swap helper method (used only in the incorrect attempt).
     */
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
