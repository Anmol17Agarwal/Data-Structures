package DynamicProgramming;

public class RodCut {
    public static void main(String[] args) {
    int[] price = {0,1,5,8,9,10,17,17,20};
        System.out.println(rodCutRecursion(price, price.length-1));
        System.out.println(rodCutTD(price, price.length-1,new int[price.length] ));
        System.out.println(rodCuttingBU(price));
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

    public static int rodCuttingBU(int[] price){
        int[] strg = new int[price.length];
        strg[0]=price[0];
        strg[1]=price[1];
        for (int n = 2; n < price.length ; n++) {
            int max = price[n];
            int left = 1;
            int right = n-1;
            while(left<=right){

                int fp = strg[left];
                int sp = strg[right];
                int total = fp+sp;

                if(max<total){
                    max=total;
                }

                left++;
                right--;
            }
            strg[n] = max;
        }
        return strg[strg.length-1];
    }

}
