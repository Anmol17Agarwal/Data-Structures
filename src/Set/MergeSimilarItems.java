package Set;
//LeetCODE QUESTION 2363
import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSimilarItems {
    public static void main(String[] args) {
        int[][] items1 ={{1,1},{4,5},{3,8}};
        int[][] items2 = {{3,1},{1,5}};
        int item1Length = items1.length;
        int item2Length = items2.length;

        for (int i = 0; i < item1Length; i++) {
            for (int j = 0; j < item2Length; j++) {
                if(items1[i][0]==items2[j][0]){
                    items1[i][1]=items1[i][1]+items2[j][1];
                }
            }
        }
        int[][] sortedArr = Arrays.stream(items1)
                .sorted((a,b)->Integer.compare(a[0],b[0]))
                .toArray(int[][]::new);
        for (int[] row : sortedArr) {
            System.out.println(Arrays.toString(row));
        }

    }
}
