package BitMasking;

public class BitManipulation {
    public static void main(String[] args) {
        if((extractKthBit(22,5)!=0)){
            System.out.println("kth bit is not 0");
        }else{
            System.out.println("kth bit is 0");
        }
        System.out.println(setKthBit(22,1));
        System.out.println(resetBit(23,3));
        System.out.println(rightMostSetBit(6));
        System.out.println(addOne(6));
        for(int i=0;i<32;i++){
            System.out.print(magicNumber(i)+" ");
        }

    }
    public static int extractKthBit(int n, int k) {
        int mask=1;
        mask=mask<<(k-1);
        int res=n&mask;
        return res;
    }

    public static int setKthBit(int n, int k) {
        int mask=1;
        mask=mask<<(k-1);
        int res=n|mask;
        return res;
    }

    public static int resetBit(int n, int k) {
        int mask=1;
        mask=~(mask<<(k-1));
        int res=n&mask;
        return res;
    }

    //it will return the position of the rightmost bit having value 1
    public static int rightMostSetBit(int n) {
        int pos=1;
        int mask=1;
        while((n&mask)==0){
            pos++;
            mask=mask<<1;
        }
        return pos;
    }

    public static int addOne(int n) {
        int mask=1;
        while((n&mask)!=0){
            n=n^mask;
            mask=mask<<1;
        }
        n=n^mask;
        return n;
    }

//    Question: Power of 5 or Sum of power of 5
    public static int magicNumber(int n) {
        int ans=0;
        int pow=1;
        while(n!=0){
            pow=pow*5;
            if((n&1)==1){
                ans=ans+pow;
            }
            n=n>>1;
        }
        return ans;
    }

/*
    Question: there is a pascal triangle of size n
    1  = 1
    1 1 = 2
    1 2 1 = 4
    1 3 3 1 = 8
    1 4 6 4 1 = 16
    1 5 10 10 5 1 = 32
    now find the sum of all the numbers in the pascal triangle
*/
    public static int pascalSum(int n) {
        int res = (1<<n);
        return res - 1;
    }

    // Question: find the number is power of 2 or not
    public static boolean isPowerOf2(int n) {
        return (n & (n-1)) == 0;
    }
}
