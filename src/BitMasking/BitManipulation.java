package BitMasking;

public class BitManipulation {
    public static void main(String[] args) {
        if((extractKthBit(22,5)!=0)){
            System.out.println("kth bit is not 0");
        }else{
            System.out.println("kth bit is 0");
        }
        System.out.println(setKthBit(22,1));
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
}
