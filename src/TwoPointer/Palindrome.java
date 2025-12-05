package TwoPointer;

public class Palindrome {
    public static void main(String[] args) {
        String word = "A man, a plan, a canal: Panama";
        word = word.replaceAll("[^a-zA-Z0-9]+","").toLowerCase();
        int i=0;
        int j=word.length()-1;
        while (i<j){
            if(word.charAt(i)!=word.charAt(j)){
                System.out.println("Word is not Palindrome");
                return;
            }
            i++;j--;
        }
        System.out.println("Word is Palindrome");
    }
}
