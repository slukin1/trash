package cn.sharesdk.loopshare.utils;

public class g {
    public static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null && str.equals(str2)) {
            return true;
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        return true;
    }
}
