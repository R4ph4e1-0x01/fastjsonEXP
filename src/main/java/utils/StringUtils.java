package utils;

public  class StringUtils {
    public static boolean isNull(String input){
        if((input==null)||(input.trim().length()==0)){
            return true;
        }
        return false;
    }
}
