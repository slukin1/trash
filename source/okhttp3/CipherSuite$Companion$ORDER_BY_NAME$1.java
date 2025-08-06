package okhttp3;

import java.util.Comparator;
import kotlin.jvm.internal.x;

public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator<String> {
    public int compare(String str, String str2) {
        int min = Math.min(str.length(), str2.length());
        int i11 = 4;
        while (i11 < min) {
            char charAt = str.charAt(i11);
            char charAt2 = str2.charAt(i11);
            if (charAt == charAt2) {
                i11++;
            } else if (x.c(charAt, charAt2) < 0) {
                return -1;
            } else {
                return 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return 0;
        }
        if (length < length2) {
            return -1;
        }
        return 1;
    }
}
