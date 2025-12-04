package String;

import java.util.Arrays;

public class ReverseTheString {
    public static void main(String[] args) {
        String input = "   the    sky is blue";
        String input1="  Hello,,,   world!!  This is---Java   ";

        String[] arr = input.trim().split("\\s+");
        StringBuilder output = new StringBuilder();
        for (int i = arr.length-1; i >=0 ; i--) {
            output.append(arr[i]);
            if(i>0)output.append(" ");
        }
        System.out.println(output);


        input1 = input1.trim().replaceAll("[-!,\\s]+", " ");
        String[] arr1 = input1.split(" ");
        System.out.println(Arrays.toString(arr1));
    }
}
