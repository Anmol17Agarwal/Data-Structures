package Extra;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;           // simple increment, no carry left
                return digits;
            }
            digits[i] = 0;             // 9 rolls over to 0, carry continues
        }

        // If we got here, it was like 9, 99, 999, ...
        int[] res = new int[digits.length + 1];
        res[0] = 1;                    // e.g., 999 -> 1000
        return res;
    }
}


