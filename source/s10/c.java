package s10;

import com.xiaomi.mipush.sdk.Constants;

public class c {
    public static String a(String str) {
        if (str.startsWith("\"")) {
            str = str.substring(1, str.length());
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("--")) {
            return str.substring(2, str.length());
        }
        return str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? str.substring(1, str.length()) : str;
    }
}
