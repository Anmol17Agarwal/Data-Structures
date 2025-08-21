package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(pascalTriangle(5));
    }

    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> traingle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                row.add(pascal(i,j));
            }
            traingle.add(row);
        }
        return traingle;
    }
    public static int pascal(int r, int c) {
        if (c == 0 || c == r) return 1;
        return pascal(r - 1, c - 1) + pascal(r - 1, c);
    }
}
