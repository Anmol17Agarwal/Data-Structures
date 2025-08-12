package DynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "saturday";
        String word2 = "sunday";
        System.out.println(minDistanceRecursive(word1, word2));
//        System.out.println(minDistanceVirtualIndex(word1,word2,0,0));
//        System.out.println(minDistanceVirtualIndexTB(word1,word2,0,0,new int[word1.length()][word2.length()]));
//        System.out.println(minDistanceBU(word1,word2));
    }
    public static int minDistanceRecursive(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        char ch1 = word1.charAt(0);
        char ch2 = word2.charAt(0);

        String ros1 = word1.substring(1);
        String ros2 = word2.substring(1);

        int ans =0;
        if(ch1 == ch2) {
            ans = minDistanceRecursive(ros1, ros2);
        }else{
            int insert = minDistanceRecursive(ros1, word2);
            int delete = minDistanceRecursive(word1, ros2);
            int replace = minDistanceRecursive(ros1, ros2);
            ans =  Math.min(insert, Math.min(delete, replace)) + 1;
        }
        return ans;
    }

    public static int minDistanceVirtualIndex(String word1, String word2,int vidx1, int vidx2) {
        if(vidx1 == word1.length() || vidx2 == word2.length()) {
            return Math.max(word1.length()-vidx1, word2.length()-vidx2);
        }
        char ch1 = word1.charAt(vidx1);
        char ch2 = word2.charAt(vidx2);

        int ans =0;
        if(ch1 == ch2) {
            ans = minDistanceVirtualIndex(word1, word2, vidx1+1, vidx2+1);
        }else{
            int insert = minDistanceVirtualIndex(word1, word2, vidx1, vidx2+1);
            int delete = minDistanceVirtualIndex(word1, word2, vidx1+1, vidx2);
            int replace = minDistanceVirtualIndex(word1, word2, vidx1+1, vidx2+1);
            ans =  Math.min(insert, Math.min(delete, replace)) + 1;
        }
        return ans;
    }

    public static int minDistanceVirtualIndexTB(String word1, String word2,int vidx1, int vidx2, int[][] dp) {
        if(vidx1 == word1.length() || vidx2 == word2.length()) {
            return Math.max(word1.length()-vidx1, word2.length()-vidx2);
        }

        if(dp[vidx1][vidx2] != 0) {
            return dp[vidx1][vidx2];
        }
        char ch1 = word1.charAt(vidx1);
        char ch2 = word2.charAt(vidx2);

        int ans =0;
        if(ch1 == ch2) {
            ans = minDistanceVirtualIndexTB(word1, word2, vidx1+1, vidx2+1, dp);
        }else{
            int insert = minDistanceVirtualIndexTB(word1, word2, vidx1, vidx2+1,dp);
            int delete = minDistanceVirtualIndexTB(word1, word2, vidx1+1, vidx2,dp);
            int replace = minDistanceVirtualIndexTB(word1, word2, vidx1+1, vidx2+1,dp);
            ans =  Math.min(insert, Math.min(delete, replace)) + 1;
        }
        dp[vidx1][vidx2] = ans;
        return ans;
    }

    public static int minDistanceBU(String word1, String word2) {
    int[][] dp = new int[word1.length()+1][word2.length()+1];
   //filling: bottom to top and right to left
    for(int row=word1.length();row>=0;row--) {
        for(int col=word2.length();col>=0;col--) {
            //base case: deletion ops
            if(row == word1.length()) {
                dp[row][col] = word2.length() - col;
            }
            //base case: insertion ops
            else if(col == word2.length()) {
                dp[row][col] = word1.length() - row;
            }
            //you are filling the intermidiate cells
            else{
                if(word1.charAt(row) == word2.charAt(col)) {
                    dp[row][col] = dp[row+1][col+1];
                }else{
                    int insert = dp[row][col+1];
                    int delete = dp[row+1][col];
                    int replace = dp[row+1][col+1];
                    dp[row][col] = 1 + Math.min(insert, Math.min(delete, replace));

                }
            }
        }
    }
    return dp[0][0];
    }
}
