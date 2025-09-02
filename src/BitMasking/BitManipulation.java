package BitMasking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class BitManipulation {
    public static void main(String[] args) {
        if((extractKthBit(22,5)!=0)){
            System.out.println("kth bit is not 0");
        }else{
            System.out.println("kth bit is 0");
        }
//        System.out.println(setKthBit(22,1));
//        System.out.println(resetBit(23,3));
//        System.out.println(rightMostSetBit(6));
        System.out.println(addOne(6));
        System.out.println("++++++++++++++++++++++++++");
        for(int i=0;i<32;i++){
            System.out.print(magicNumber(i)+" ");
        }
        missingNumber(new int[]{2,3,5,6},6);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(4);
        set.add(5);
        System.out.println(set.size()+""+set.toString());
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
        if(n==0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }

    //Question : Find missing two number from an array
    public static void missingNumber(int[] numbers, int n){
        int z = 0;
        for (int i = 0; i < numbers.length; i++) {
            z = z ^ numbers[i];
        }
        for(int i =1;i<=n;i++){
            z = z ^ i;
        }
//        System.out.println(z);
        int setBit = z & ~(z-1);
        System.out.println(setBit);

        int group1=0;int group2=0;

        for (int i = 0; i < numbers.length ; i++) {
            if((numbers[i]&setBit)==setBit){
                group1 = group1^numbers[i];
            }else{
                group2 = group2^numbers[i];
            }
        }
        for (int i = 1; i <=n ; i++) {
            if ((i & setBit) == setBit) {
                group1 = group1 ^ i;
            } else {
                group2 = group2 ^ i;
            }
        }
        System.out.println("First Missing Number is "+group1);
        System.out.println("First Missing Number is "+group2);
    }

}
