package DynamicProgramming;

public class WildCardMatching {
    public static void main(String[] args) {
    String src = "aaabbabababbbaab";
    String pattern = "aaa*******baab";
        System.out.println(wildCardMatchingRecursive(src,pattern));
    }
    public static boolean wildCardMatchingRecursive(String src,String pattern){
        if(src.length()==0 && pattern.length()==0){
            return true;
        }
        if(src.length()!=0 && pattern.length()==0){
           return false;
        }
        if(src.length()==0 && pattern.length()!=0){
            for (int i = 0; i < pattern.length(); i++) {
                if(pattern.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        char srcCh=src.charAt(0);
        char patternCh=pattern.charAt(0);
        String roSrc = src.substring(1);
        String roPattern = pattern.substring(1);
        boolean ans;
        if(srcCh == patternCh || patternCh == '?'){
            ans = wildCardMatchingRecursive(roSrc,roPattern);
        }else if(patternCh == '*'){
            boolean blank = wildCardMatchingRecursive(src,roPattern);
            boolean multiple = wildCardMatchingRecursive(roSrc,pattern);
            ans = blank || multiple;
        }else{
            ans = false;
        }
        return ans;
    }
}
