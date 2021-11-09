package com.koziuberdin;

public class ReversStringUtils {

    public static String reverse(String src) {
        String res = "";
        for (int i = src.length() - 1; i >= 0; i--) {
            res += src.charAt(i);
        }
        return res;

    }

    public static String reverse(String src, String dest) {
        return src.replace(dest, reverse(dest));
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        //return src.substring(0, firstIndex) + reverse(src.substring(firstIndex, lastIndex)) + src.substring(lastIndex-1);

        String res = "";
        for (int i = 0; i < firstIndex; i++) {
            res += src.charAt(i);

        }

        for (int i = lastIndex; i >= firstIndex; i--) {
            res += src.charAt(i);

        }
        for (int i = lastIndex + 1; i < src.length() ; i++) {
            res += src.charAt(i);
        }
        return res;




    }
}
