package Extra;

public class SubString {
    public static void main(String[] args) {
        String str1 = "testifgisgun";
        String str2 = "fun";
        System.out.println(match(str1,str2,0));
    }
    public static boolean match(String str1,String str2){
        if(str1.length()==0 && str2.length()==0){
            return true;
        }
        if(str1.length()!=0 && str2.length()==0){
            return false;
        }
        if(str1.length()==0 && str2.length()!=0){
            return false;
        }
        char ch1 = str1.charAt(0);
        char ch2 = str2.charAt(0);

        String ros1 = str1.substring(1);
        String ros2 = str2.substring(1);
        if(ch1==ch2){
            return match(ros1,ros2);
        }else{
            return match(ros1,str2);
        }
    }
}
