package DynamicProgramming;

public class RodCut {
    public static void main(String[] args) {
    int[] price = {0,1,5,8,9,10,17,17,20};
        System.out.println(rodCutRecursion(price, price.length-1));
        System.out.println(rodCutTD(price, price.length-1,new int[price.length] ));
    }
    public static int rodCutRecursion(int[] price,int n){
        int max = price[n];
        int left = 1;
        int right = n-1;
        while(left<=right){

            int fp = rodCutRecursion(price,left);
            int sp = rodCutRecursion(price,right);
            int total = fp+sp;

            if(max<total){
                max=total;
            }

            left++;
            right--;
        }
        return max;
    }
    public static int rodCutTD(int[] price,int n, int[]strg){
        if(strg[n]!=0){
            return strg[n];
        }
        int max = price[n];
        int left = 1;
        int right = n-1;
        while(left<=right){

            int fp = rodCutRecursion(price,left);
            int sp = rodCutRecursion(price,right);
            int total = fp+sp;

            if(max<total){
                max=total;
            }

            left++;
            right--;
        }
        strg[n] = max;
        return max;
    }

}
