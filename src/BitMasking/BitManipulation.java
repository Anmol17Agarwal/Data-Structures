package BitMasking;

public class BitManipulation {
    public static void main(String[] args) {
        if((extractKthBit(22,5)!=0)){
            System.out.println("kth bit is not 0");
        }else{
            System.out.println("kth bit is 0");
        }
    }
    public static int extractKthBit(int n, int k) {
        int j=1;
        j=j<<(k-1);
        int res=n&j;
        return res;
    }
}
