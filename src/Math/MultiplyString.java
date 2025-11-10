package Math;

//Leetcode question number 43
public class MultiplyString {
    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));      // Output: 6
        System.out.println(multiply("123", "456"));  // Output: 56088
        System.out.println(multiply("0", "52"));
    }

    private static String multiply(String number1, String number2) {
        if(number1.equals("0") || number2.equals("0")){
            return "0";
        }
        int m = number1.length();
        int n = number2.length();
        int[] result = new int[m+n];

        for (int i = m-1; i >=0 ; i--) {
            int digit1 = number1.charAt(i) - '0';
            for (int j = n-1; j >=0 ; j--) {
                int digit2 = number2.charAt(j) - '0';
                int sum = result[i+j+1] + digit1*digit2;

                result[i+j+1] = sum%10;
                result[i+j] += sum/10;

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num:result){
            if(sb.length()==0 && num==0)continue;
            sb.append(num);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
