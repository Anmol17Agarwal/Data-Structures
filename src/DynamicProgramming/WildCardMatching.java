package DynamicProgramming;

public class WildCardMatching {
    public static void main(String[] args) {
    String src = "aaabbabababbbaab";
    String pattern = "aaa*******baab";
        System.out.println(wildCardMatchingRecursive(src,pattern));
        System.out.println(wildCardMatchingRecursiveTD(src,pattern,0,0));
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

    public static boolean wildCardMatchingRecursiveTD(String src,String pattern,int svidx,int pvidx){
        if(src.length()==svidx && pattern.length()==pvidx){
            return true;
        }
        if(src.length()!=svidx && pattern.length()==pvidx){
            return false;
        }
        if(src.length()==svidx && pattern.length()!=pvidx){
            for (int i = pvidx; i < pattern.length(); i++) {
                if(pattern.charAt(pvidx)!='*'){
                    return false;
                }
            }
            return true;
        }
        char srcCh=src.charAt(svidx);
        char patternCh=pattern.charAt(pvidx);
        boolean ans;
        if(srcCh == patternCh || patternCh == '?'){
            ans = wildCardMatchingRecursiveTD(src,pattern,svidx+1,pvidx+1);
        }else if(patternCh == '*'){
            boolean blank = wildCardMatchingRecursiveTD(src,pattern,svidx,pvidx+1);
            boolean multiple = wildCardMatchingRecursiveTD(src,pattern,svidx+1,pvidx);
            ans = blank || multiple;
        }else{
            ans = false;
        }
        return ans;
    }
}
